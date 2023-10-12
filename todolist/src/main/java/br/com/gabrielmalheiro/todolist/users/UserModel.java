package br.com.gabrielmalheiro.todolist.users;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class UserModel {

    private String username;
    private String name;
    private String password;
}
