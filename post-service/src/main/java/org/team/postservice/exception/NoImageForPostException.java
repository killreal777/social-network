package org.team.postservice.exception;

import java.util.NoSuchElementException;

public class NoImageForPostException extends NoSuchElementException {
    public NoImageForPostException() {
        super("This post doesn't have image");
    }
}
