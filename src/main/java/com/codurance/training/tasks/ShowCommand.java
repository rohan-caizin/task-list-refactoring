package com.codurance.training.tasks;


public class ShowCommand implements Command{
    private final Projects projects;
    private final java.io.Writer writer;
    public ShowCommand(Projects projects, java.io.Writer writer) {
        this.projects = projects;
        this.writer = writer;
    }
    @Override
    public void execute(String arguments) throws Exception{
        projects.formatProject(writer);
    }
}
