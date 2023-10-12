package br.com.gabrielmalheiro.todolist.users;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class UserModel {
    /* If you want a prop to have a specific accessor like the name prop should only be readable and should not have a setter 
     * You can add the annotation like this:
      @Getter */
    private String username;
    private String name;
    private String password;
}
