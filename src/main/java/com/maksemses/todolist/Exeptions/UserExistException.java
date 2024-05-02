package com.maksemses.todolist.Exeptions;

public class UserExistException extends Exception{
    public UserExistException(String message){
        super(message);
    }
}
