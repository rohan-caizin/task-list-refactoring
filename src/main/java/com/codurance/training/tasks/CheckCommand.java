package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class CheckCommand implements Command{
    private final Projects projects;
    private final boolean done;

    public CheckCommand(Projects projects, boolean done) {
        this.projects = projects;
        this.done = done;
    }
    @Override
    public void execute(String arguments) throws Exception{
        int id = Integer.parseInt(arguments);
        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.%n", id);

    }
}