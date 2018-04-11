package com.example.SpringSecurity.repositories;

import com.example.SpringSecurity.entities.Task;
import com.example.SpringSecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository  extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);
	
}
