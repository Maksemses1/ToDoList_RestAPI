package com.maksemses.todolist.Controllers;

import com.maksemses.todolist.Entities.UserEntity;
import com.maksemses.todolist.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1//user")
public class UserController {
    private final UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserEntity User){
        return userService.save(User);
    }
    @GetMapping()
    public ResponseEntity getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }
}
