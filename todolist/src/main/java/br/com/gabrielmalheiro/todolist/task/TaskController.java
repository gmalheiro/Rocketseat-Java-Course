package br.com.gabrielmalheiro.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    /* We use AutoWired for spring to manage the instance */
    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/createTask")
    public TaskModel create(@RequestBody TaskModel taskModel){
        var task = this.taskRepository.save(taskModel);
        return task;
    }
}
