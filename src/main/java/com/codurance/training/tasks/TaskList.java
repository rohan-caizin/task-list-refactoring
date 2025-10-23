package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public final class TaskList {

    private final Projects projects = new Projects();
    private final Writer writer;
    private final Map<String, Command> commands = new HashMap<>();

    private void registerCommands() {
        commands.put("show", new ShowCommand(projects, writer));
        commands.put("add", new AddCommand(projects));
        commands.put("check", new CheckCommand(projects, true));
        commands.put("uncheck", new CheckCommand(projects, false));
    }
    public TaskList(Writer writer) {
        this.writer = writer;
        registerCommands();
    }

    public void execute(String commandLine) throws Exception {
        String[] parts = commandLine.split(" ", 2);
        String commandName = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";

        Command command = commands.get(commandName);
        if (command == null) {
            throw new IllegalArgumentException("Unknown command: " + commandName);
        }

        command.execute(arguments);
    }

}
