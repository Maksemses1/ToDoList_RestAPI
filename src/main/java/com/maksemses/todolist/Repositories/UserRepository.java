package com.maksemses.todolist.Repositories;

import com.maksemses.todolist.Entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    public boolean existsByLogin(String login);
}
