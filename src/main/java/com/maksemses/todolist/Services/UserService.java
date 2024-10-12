package com.maksemses.todolist.Services;

import com.maksemses.todolist.Entities.UserEntity;
import com.maksemses.todolist.Exeptions.NotFoundUserException;
import com.maksemses.todolist.Models.UserModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity getUsers();
    ResponseEntity save(UserEntity User);
    boolean isValidUser(UserEntity User) throws Exception;
    boolean isUserLogin(String login);
    ResponseEntity deleteUserById(Long id);
    UserModel getModel(Long id) throws NotFoundUserException;
    UserEntity getUserEntity(Long id) throws NotFoundUserException;
    boolean isUserById(Long id) throws NotFoundUserException;
}
