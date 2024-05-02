package com.maksemses.todolist.Services;

import com.maksemses.todolist.Entities.ToDoListEntity;
import com.maksemses.todolist.Entities.UserEntity;
import com.maksemses.todolist.Exeptions.NotFoundToDoList;
import com.maksemses.todolist.Exeptions.NotFoundUserException;
import com.maksemses.todolist.Models.ToDoListModel;
import com.maksemses.todolist.Repositories.ToDoListRepository;
import com.maksemses.todolist.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public ResponseEntity create(ToDoListEntity toDoListEntity, Long userid){
        try {
            if (userService.isUserById(userid)){
                UserEntity user = userRepository.findById(userid).get();
                toDoListEntity.setUser(user);
                toDoListRepository.save(toDoListEntity);
                return ResponseEntity.ok().body("Новый лист задач создан");
            }
        } catch (NotFoundUserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }
    public ResponseEntity delete(Long id){
        try {
            if(isToDoListById(id)){
                toDoListRepository.deleteById(id);
                return ResponseEntity.ok().body("Список задач удален");
            }
        } catch (NotFoundToDoList e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }
    public ResponseEntity get(Long id){
        try {
            if (isToDoListById(id)){
                ToDoListEntity toDoListEntity = toDoListRepository.findById(id).get();
                return ResponseEntity.ok().body(ToDoListModel.toModel(toDoListEntity));
            }
        } catch (NotFoundToDoList e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }
    boolean isToDoListById(Long id) throws NotFoundToDoList {
        if (toDoListRepository.existsById(id)){
            return true;
        }
        throw new NotFoundToDoList();
    }
}
