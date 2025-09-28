// src/main/java/com/example/todolist/service/TodoService.java
package com.example.todolist.service;

import com.example.todolist.model.TodoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private List<TodoItem> todos = new ArrayList<>();

    public TodoService() {
        // Mock data inicial
        todos.add(new TodoItem(1L, "Aprender Spring Boot", false));
        todos.add(new TodoItem(2L, "Hacer ejercicio", true));
        todos.add(new TodoItem(3L, "Leer un libro", false));
    }

    public List<TodoItem> getAllTodos() {
        return todos;
    }

    public Optional<TodoItem> getTodoById(Long id) {
        return todos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
    }

    public TodoItem createTodo(TodoItem todo) {
        Long newId = todos.stream().mapToLong(TodoItem::getId).max().orElse(0) + 1;
        todo.setId(newId);
        todos.add(todo);
        return todo;
    }

    public Optional<TodoItem> updateTodo(Long id, TodoItem updatedTodo) {
        Optional<TodoItem> todoOpt = getTodoById(id);
        todoOpt.ifPresent(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
        });
        return todoOpt;
    }

    public boolean deleteTodo(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
}
