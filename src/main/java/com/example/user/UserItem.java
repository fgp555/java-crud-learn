// src/main/java/com/example/user/UserItem.java
package com.example.user;

public class UserItem {
    private Integer id;
    private String name;
    private String email;

    // Constructor vacío (obligatorio para que Jackson pueda crear el objeto)
    public UserItem() {}

    // Constructor con parámetros
    public UserItem(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters y setters
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    // @Override
    // public String toString() {
    //     return "UserItem{name='" + name + "', email='" + email + "'}";
    // }
}
