package br.com.gabrielmalheiro.todolist.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/createUser")
    public UserModel create(@RequestBody UserModel userModel){
        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}
