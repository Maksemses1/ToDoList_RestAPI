package com.maksemses.todolist.Repositories;

import com.maksemses.todolist.Entities.ToDoListEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoListEntity, Long> {
}
