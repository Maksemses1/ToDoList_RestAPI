package com.maksemses.todolist.Services.Impl;

import com.maksemses.todolist.Entities.UserEntity;
import com.maksemses.todolist.Exeptions.NotFoundUserException;
import com.maksemses.todolist.Exeptions.UserExistException;
import com.maksemses.todolist.Models.UserModel;
import com.maksemses.todolist.Repositories.UserRepository;
import com.maksemses.todolist.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;

    public ResponseEntity getUsers() {
        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();
        return ResponseEntity.ok().body(UserModel.toModels(userEntities));
    }
    public ResponseEntity save(UserEntity User){
        try {
            if (isValidUser(User)){
                userRepository.save(User);
                return ResponseEntity.ok().body("Пользователь сохранен");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }
    public boolean isValidUser(UserEntity User) throws Exception {
        if (!isUserLogin(User.getLogin())){
            return true;
        }
        else {
            throw new UserExistException("Пользователь уже существует");
        }
    }
    public boolean isUserLogin(String login){
        return userRepository.existsByLogin(login);
    }
    public ResponseEntity getUserById(Long id) {
        try {
            return ResponseEntity.ok().body(getModel(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    public ResponseEntity deleteUserById(Long id) {
        try {
            if (isUserById(id)){
                userRepository.deleteById(id);
                return ResponseEntity.ok().body("Успешно удален");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }

    public UserModel getModel(Long id) throws NotFoundUserException {
        return UserModel.toModel(getUserEntity(id));
    }

    public UserEntity getUserEntity(Long id) throws NotFoundUserException {
        if (isUserById(id)){
            return userRepository.findById(id).get();
        }
        return null;
    }

    public boolean isUserById(Long id) throws NotFoundUserException {
        if (userRepository.existsById(id)){
            return true;
        }
        else {
            throw new NotFoundUserException("Пользователь не найден");
        }
    }
}
