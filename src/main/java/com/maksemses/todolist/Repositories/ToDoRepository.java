package com.maksemses.todolist.Repositories;

import com.maksemses.todolist.Entities.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {
}
