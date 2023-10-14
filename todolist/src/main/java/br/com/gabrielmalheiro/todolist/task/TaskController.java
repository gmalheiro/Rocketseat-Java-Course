package br.com.gabrielmalheiro.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    /* We use AutoWired for spring to manage the instance */
    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/createTask")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        
        var userId = request.getAttribute("idUser");
        taskModel.setUserId((UUID) userId);
                
        System.out.println("In task controller");
        
        var currentDate = LocalDateTime.now();
        
        if(currentDate.isAfter(taskModel.getStartAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Start date must be greater than the actual date");
        }

        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
