package com.maksemses.todolist.Services;

import com.maksemses.todolist.Entities.ToDoEntity;
import com.maksemses.todolist.Exeptions.NotFoundToDo;
import org.springframework.http.ResponseEntity;

public interface ToDoService {
    ResponseEntity createToDo(ToDoEntity toDoEntity, Long id);
    ResponseEntity completed(Long id);
    ResponseEntity deleteToDo(Long id);
    ResponseEntity getToDo(Long id);
    boolean isToDo(Long id) throws NotFoundToDo;
}
