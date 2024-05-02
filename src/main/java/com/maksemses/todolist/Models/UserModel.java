package com.maksemses.todolist.Models;

import com.maksemses.todolist.Entities.ToDoEntity;
import com.maksemses.todolist.Entities.UserEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserModel {
    private Long id;
    private String login;
    private List<ToDoListModel> toDoListModels;

    public static UserModel toModel(UserEntity userEntity){
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setLogin(userEntity.getLogin());
        userModel.setToDoListModels(ToDoListModel.toModels(userEntity.getToDoListEntity()));
        return userModel;
    }
    public static List<UserModel> toModels(List<UserEntity> userEntityList){
        List<UserModel> userModelList = new ArrayList<>();
        for(UserEntity userEntity : userEntityList){
            userModelList.add(toModel(userEntity));
        }
        return userModelList;
    }
}
