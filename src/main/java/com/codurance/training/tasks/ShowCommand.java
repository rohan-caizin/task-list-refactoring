package com.codurance.training.tasks;


import java.io.Writer;

public class ShowCommand implements Command{
    private final Projects projects;
    private final Writer writer;
    public ShowCommand(Projects projects, Writer writer) {
        this.projects = projects;
        this.writer = writer;
    }
    @Override
    public void execute(String arguments) throws Exception{
        projects.formatProject(writer);
    }
}
