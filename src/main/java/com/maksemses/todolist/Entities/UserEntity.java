package com.maksemses.todolist.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ToDoListEntity> toDoListEntity;
}
