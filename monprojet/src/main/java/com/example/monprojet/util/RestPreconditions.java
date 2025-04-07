package com.example.monprojet.util;

import com.example.monprojet.Errors.MyResourceNotFoundException;

public class RestPreconditions {
    private RestPreconditions() {
        throw new AssertionError();
    }

    public static void checkFound(final boolean expression,String message) {
        if (!expression) {
            throw new MyResourceNotFoundException("message");
        }
    }


    public static <T> T checkFound(final T resource, String entityName, String notFound) {
        if (resource == null) {
            throw new MyResourceNotFoundException();
        }

        return resource;
    }

    public static <T> T checkFound(final T resource,String message) {
        if (resource == null) {
            throw new MyResourceNotFoundException(message);
        }

        return resource;
    }
}
