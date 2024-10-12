package com.maksemses.todolist.Controllers;

import com.maksemses.todolist.Entities.ToDoListEntity;
import com.maksemses.todolist.Services.Impl.ToDoListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todolist")
public class ToDoListController {
    private final ToDoListServiceImpl toDoListServiceImpl;

    @PostMapping
    public ResponseEntity create(@RequestBody ToDoListEntity toDoListEntity,
                                 @RequestParam Long userId){
        return toDoListServiceImpl.create(toDoListEntity, userId);
    }
    @GetMapping
    public ResponseEntity get(@RequestParam Long id){
        return toDoListServiceImpl.get(id);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return toDoListServiceImpl.delete(id);
    }
}
