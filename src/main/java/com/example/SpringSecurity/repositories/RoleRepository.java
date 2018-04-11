package com.example.SpringSecurity.repositories;

import com.example.SpringSecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, String> {
 
}
