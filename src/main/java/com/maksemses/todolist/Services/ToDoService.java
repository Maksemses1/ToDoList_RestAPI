package com.maksemses.todolist.Services;

import com.maksemses.todolist.Entities.ToDoEntity;
import com.maksemses.todolist.Entities.ToDoListEntity;
import com.maksemses.todolist.Entities.UserEntity;
import com.maksemses.todolist.Exeptions.NotFoundToDo;
import com.maksemses.todolist.Exeptions.NotFoundToDoList;
import com.maksemses.todolist.Exeptions.NotFoundUserException;
import com.maksemses.todolist.Models.ToDoModel;
import com.maksemses.todolist.Repositories.ToDoListRepository;
import com.maksemses.todolist.Repositories.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final ToDoListRepository toDoListRepository;
    private final ToDoListService toDoListService;
    public ResponseEntity createToDo(ToDoEntity toDoEntity, Long id) {
        try {
            if (toDoListService.isToDoListById(id)){
            ToDoListEntity list = toDoListRepository.findById(id).get();
            toDoEntity.setList(list);
            toDoRepository.save(toDoEntity);
            return ResponseEntity.ok().body("Пользователю: " + list.getId() + " " +
                    "Была добавлена задача:" + toDoEntity.getTitle());
            }
        } catch (NotFoundToDoList e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }
    public ResponseEntity completed(Long id){
        try {
            if(isToDo(id)){
                ToDoEntity toDoEntity = toDoRepository.findById(id).get();
                toDoEntity.setCompleted(!toDoEntity.isCompleted());
                toDoRepository.save(toDoEntity);
                return ResponseEntity.ok().body("Теперь у задачи id: " + toDoEntity.getId() + ". " +
                        "Статус выполнено стоит на: " + toDoEntity.isCompleted());
            }
        } catch (NotFoundToDo e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }
    public  ResponseEntity deleteToDo(Long id){
        toDoRepository.deleteById(id);
        return ResponseEntity.ok().body("Задача удалена");
    }
    public ResponseEntity getToDo(Long id) {
        try {
            if(isToDo(id)){
            ToDoEntity toDoEntity = toDoRepository.findById(id).get();
            return ResponseEntity.ok().body(ToDoModel.toModel(toDoEntity));
        }
        } catch (NotFoundToDo e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Ошибка");
    }
    boolean isToDo(Long id) throws NotFoundToDo {
        if(toDoRepository.existsById(id)){
            return true;
        }
        throw new NotFoundToDo();
    }
}
