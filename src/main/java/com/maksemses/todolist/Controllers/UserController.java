package com.maksemses.todolist.Controllers;

import com.maksemses.todolist.Entities.UserEntity;
import com.maksemses.todolist.Services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        return userServiceImpl.getUsers();
    }
    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserEntity User){
        return userServiceImpl.save(User);
    }
    @GetMapping()
    public ResponseEntity getUserById(@RequestParam Long id){
        return userServiceImpl.getUserById(id);
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id){
        return userServiceImpl.deleteUserById(id);
    }
}
