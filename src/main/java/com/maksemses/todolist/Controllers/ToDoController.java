package com.maksemses.todolist.Controllers;

import com.maksemses.todolist.Entities.ToDoEntity;
import com.maksemses.todolist.Services.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDoEntity,
                                     @RequestParam Long listId)
    {
        return toDoService.createToDo(toDoEntity, listId);
    }
    @PutMapping("/completed")
    public ResponseEntity completed(@RequestParam Long id){
        return toDoService.completed(id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id){
        return toDoService.deleteToDo(id);
    }
    @GetMapping
    public ResponseEntity getToDo(@RequestParam Long id){
        return toDoService.getToDo(id);
    }

}
