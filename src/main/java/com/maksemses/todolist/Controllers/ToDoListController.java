package com.maksemses.todolist.Controllers;

import com.maksemses.todolist.Entities.ToDoListEntity;
import com.maksemses.todolist.Services.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1//todolist")
public class ToDoListController {
    private final ToDoListService toDoListService;

    @PostMapping
    public ResponseEntity create(@RequestBody ToDoListEntity toDoListEntity,
                                 @RequestParam Long userId){
        return toDoListService.create(toDoListEntity, userId);
    }
    @GetMapping
    public ResponseEntity get(@RequestParam Long id){
        return toDoListService.get(id);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return toDoListService.delete(id);
    }
}
