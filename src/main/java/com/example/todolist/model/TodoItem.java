// src/main/java/com/example/todolist/model/TodoItem.java
package com.example.todolist.model;

public class TodoItem {
    private Long id;
    private String title;
    private boolean completed;

    // Constructor vacío (default)
    public TodoItem() {}

    // Constructor con parámetros
    public TodoItem(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
