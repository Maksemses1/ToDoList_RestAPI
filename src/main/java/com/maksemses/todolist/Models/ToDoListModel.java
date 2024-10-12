package com.maksemses.todolist.Models;

import com.maksemses.todolist.Entities.ToDoListEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ToDoListModel {
    private Long id;
    private String title;
    private List<ToDoModel> toDoModelList;
    private Long userId;

    public static ToDoListModel toModel(ToDoListEntity toDoListEntity){
        ToDoListModel toDoListModel = new ToDoListModel();
        toDoListModel.setId(toDoListEntity.getId());
        toDoListModel.setTitle(toDoListEntity.getTitle());
        toDoListModel.setToDoModelList(ToDoModel.toModels(toDoListEntity.getToDoEntityList()));
        toDoListModel.setUserId(toDoListEntity.getUser().getId());
        return toDoListModel;
    }
    public static List<ToDoListModel> toModels(List<ToDoListEntity> toDoListEntityList){
        List<ToDoListModel> toDoListModelList = new ArrayList<>();
        for(ToDoListEntity toDoListEntity : toDoListEntityList){
            toDoListModelList.add(toModel(toDoListEntity));
        }
        return toDoListModelList;
    }
}
