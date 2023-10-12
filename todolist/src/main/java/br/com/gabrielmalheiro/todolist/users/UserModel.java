package br.com.gabrielmalheiro.todolist.users;

public class UserModel {

    private String username;
    private String name;
    private String password;

    @Override
    public String toString() {
        return (this.username + "," + this.name + "," + this.password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
