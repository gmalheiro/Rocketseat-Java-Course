package br.com.gabrielmalheiro.todolist.users;

public class UserModel {

    public String username;
    public String name;
    public String password;

    @Override 
    public String toString(){
        return (this.username + "," + this.name + "," + this.password       );
    }
}
