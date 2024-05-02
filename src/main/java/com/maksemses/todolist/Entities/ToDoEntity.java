package com.maksemses.todolist.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private ToDoListEntity list;
}
