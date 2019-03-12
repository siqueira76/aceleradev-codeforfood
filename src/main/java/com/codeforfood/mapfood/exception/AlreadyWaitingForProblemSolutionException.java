package com.codeforfood.mapfood.exception;

public class AlreadyWaitingForProblemSolutionException extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    public AlreadyWaitingForProblemSolutionException(String msg) {
        super(msg);
    }
}
