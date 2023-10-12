package br.com.gabrielmalheiro.todolist.users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "tb_users")
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    /* If you want a prop to have a specific accessor like the name prop should only be readable and should not have a setter 
     * You can add the annotation like this:
      @Getter 
      You can even specify a column by using the following annotation:
      @Column(name = "username")
      */
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
