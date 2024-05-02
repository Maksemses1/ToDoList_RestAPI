package com.maksemses.todolist.Models;

import com.maksemses.todolist.Entities.ToDoEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ToDoModel {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private Long listId;

    public static ToDoModel toModel(ToDoEntity toDoEntity) {
        ToDoModel toDoModel = new ToDoModel();
        toDoModel.setId(toDoEntity.getId());
        toDoModel.setTitle(toDoEntity.getTitle());
        toDoModel.setDescription(toDoEntity.getDescription());
        toDoModel.setCompleted(toDoEntity.isCompleted());
        toDoModel.setListId(toDoEntity.getList().getId());
        return toDoModel;
    }
    public static List<ToDoModel> toModels(List<ToDoEntity> toDoEntities) {
        List<ToDoModel> toDoModels = new ArrayList<>();
        for (ToDoEntity toDoEntity : toDoEntities){
            ToDoModel toDoModel = toModel(toDoEntity);
            toDoModels.add(toDoModel);
        }
        return toDoModels;
    }
}
