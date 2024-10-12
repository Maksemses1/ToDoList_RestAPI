package com.maksemses.todolist.Controllers;

import com.maksemses.todolist.Entities.ToDoEntity;
import com.maksemses.todolist.Services.Impl.ToDoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class ToDoController {
    private final ToDoServiceImpl toDoServiceImpl;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDoEntity,
                                     @RequestParam Long listId)
    {
        return toDoServiceImpl.createToDo(toDoEntity, listId);
    }
    @PutMapping("/completed")
    public ResponseEntity completed(@RequestParam Long id){
        return toDoServiceImpl.completed(id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id){
        return toDoServiceImpl.deleteToDo(id);
    }
    @GetMapping
    public ResponseEntity getToDo(@RequestParam Long id){
        return toDoServiceImpl.getToDo(id);
    }

}
