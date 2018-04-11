package com.example.SpringSecurity.services;


import com.example.SpringSecurity.entities.Task;
import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findByUser(User user){
        return taskRepository.findByUser(user);
    }
}
