package br.com.gabrielmalheiro.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielmalheiro.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    /* We use AutoWired for spring to manage the instance */
    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/createTasks")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        
        var userId = request.getAttribute("userId");
        taskModel.setUserId((UUID) userId);
                
        System.out.println("In task controller");
        
        var currentDate = LocalDateTime.now();
        
        if(currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Start and end date must be greater than the actual date");
        }

        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/getTasks")
    public ResponseEntity<List<TaskModel>> list(HttpServletRequest request){
        var userId = request.getAttribute("userId");

        var tasks = this.taskRepository.findByUserId((UUID) userId);
        
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<TaskModel> update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id){
         
         var task = this.taskRepository.findById(id).orElse(new TaskModel());
         
         Utils.copyNonNullProperties(taskModel, task);
        
         this.taskRepository.save(taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
