package org.team.postservice.exception;

import java.util.NoSuchElementException;

public class NoSuchPostException extends NoSuchElementException {
    public NoSuchPostException() {
        super("Post doesn't exist");
    }
}
