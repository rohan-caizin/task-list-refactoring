package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Projects extends LinkedHashMap<String,List<Task>> {
     void formatProject(Writer writer) throws IOException {
        for (Map.Entry<String, List<Task>> project : this.entrySet()) {
            writer.write(project.getKey());
            writer.write("\n");
            Tasks task = new Tasks();
            task.addAll(project.getValue());
            task.formatTasks(writer);
        }
    }
}
