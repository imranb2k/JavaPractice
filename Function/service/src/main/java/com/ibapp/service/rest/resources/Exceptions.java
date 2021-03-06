package com.ibapp.service.rest.resources;

import java.util.concurrent.Callable;

public class Exceptions {

    public static <T> T uncheck(Callable<T> fn) {
        try {
            return fn.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
