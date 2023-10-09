package br.com.gabrielmalheiro.todolist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstRoute")
public class MyFirstController {

    @GetMapping("/firstMethod")
    public String FirstMessage(){
        return "Hello World! Java";
    }

}
