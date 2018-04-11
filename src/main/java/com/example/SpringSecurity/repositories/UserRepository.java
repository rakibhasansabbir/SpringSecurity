package com.example.SpringSecurity.repositories;

import com.example.SpringSecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByName(String name);


}
