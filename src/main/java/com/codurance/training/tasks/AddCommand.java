package com.codurance.training.tasks;

import java.util.ArrayList;

public class AddCommand implements Command{
    private final Projects projects;

    public AddCommand(Projects projects) {
        this.projects = projects;
    }
    @Override
    public void execute(String arguments) throws Exception{
        String[] subcommandRest = arguments.split(" ", 2);
        String subcommand = subcommandRest[0];

        if (subcommand.equals("project")) {
            projects.put(subcommandRest[1], new ArrayList<>());
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            projects.addTasks(projectTask[0], projectTask[1]);
        } else {
            throw new IllegalArgumentException("Unknown add subcommand: " + subcommand);
        }

    }
}