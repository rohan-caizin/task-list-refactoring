package com.codurance.training.tasks;

public class IdGenerator {
    private int lastId = 1;

    public int nextId() {
        return lastId++;
    }
}
