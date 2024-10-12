package com.maksemses.todolist.Services;

import com.maksemses.todolist.Entities.ToDoListEntity;
import com.maksemses.todolist.Exeptions.NotFoundToDoList;
import org.springframework.http.ResponseEntity;

public interface ToDoListService {
    ResponseEntity create(ToDoListEntity toDoListEntity, Long userid);
    ResponseEntity delete(Long id);
    ResponseEntity get(Long id);
    boolean isToDoListById(Long id) throws NotFoundToDoList;
}
