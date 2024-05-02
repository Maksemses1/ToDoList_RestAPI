package com.maksemses.todolist.Exeptions;

public class NotFoundUserException extends Exception{
    public NotFoundUserException(String message){
        super(message);
    }
}
