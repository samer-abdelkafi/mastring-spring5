package com.todo.service;

import com.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "Jack", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(2, "Jack", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "Jill", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        return todos.stream()
                .filter(todo -> user.equals(todo.getUser()))
                .collect(Collectors.toList());
    }

    public Todo addTodo(String name, String desc, Date targetDate, boolean
            isDone) {
        Todo todo = new Todo(todoCount++, name, desc, targetDate, isDone);
        todos.add(todo);
        return todo;

    }

    public Todo retrieveTodo(int id) {
        return todos.stream()
                .filter(todo -> id == todo.getId())
                .findFirst()
                .orElseThrow(NoClassDefFoundError::new);

    }

    public Todo update(Todo todo) {
        Todo todoFound = retrieveTodo(todo.getId());
        todoFound.setUser(todo.getUser());
        todoFound.setDesc(todo.getDesc());
        todoFound.setTargetDate(todo.getTargetDate());
        todoFound.setDone(todo.isDone());
        return todoFound;
    }

    public Todo deleteById(int id) {
        Todo todo = retrieveTodo(id);
        todos.remove(todo);
        return todo;
    }
}