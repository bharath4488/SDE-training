package com.basics.amazon.learnSpringBoot.exception.user;

public class UserExceptions extends Exception{
    UserExceptions(String message){
        super(message);
    }

    public static class EmptyUserDetailsException extends UserExceptions {
        public EmptyUserDetailsException(String message){
            super(message);
        }
    }


}
