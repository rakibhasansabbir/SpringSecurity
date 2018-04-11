package com.example.SpringSecurity.services;

import com.example.SpringSecurity.entities.Role;
import com.example.SpringSecurity.entities.StakeholderInfo;
import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.repositories.RoleRepository;
import com.example.SpringSecurity.repositories.StakeholderRepository;
import com.example.SpringSecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private StakeholderRepository stakeholderRepository;

    public void createReportAdmin(User user,String createdBy) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = new Role("REPORT_ADMIN", "report admin");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setCreatedBy(createdBy);
        user.setCreatedTime(LocalDateTime.now());
        userRepository.save(user);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN", "admin");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setCreatedBy("default");
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedBy("default");
        user.setUpdatedTime(LocalDateTime.now());
        userRepository.save(user);
    }

    public void createStakeholderApitUser(User user,String createdBy) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = new Role("STAKEHOLDER_API", "Stakeholder Api User ");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setCreatedBy(createdBy);
        user.setCreatedTime(LocalDateTime.now());
        userRepository.save(user);
    }

    public void createStakeholderReportUser(User user,String createdBy) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = new Role("STAKEHOLDER_REPORT", "Stakeholder Report User ");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setCreatedBy(createdBy);
        user.setCreatedTime(LocalDateTime.now());
        userRepository.save(user);
    }

    public void createUser(User user,String createdBy) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = new Role("USER", "Stakeholder User ");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setCreatedBy(createdBy);
        user.setCreatedTime(LocalDateTime.now());
        userRepository.save(user);
    }

    public void createStakeholder(StakeholderInfo stakeholderInfo) {


        stakeholderRepository.save(stakeholderInfo);
    }

    public User findOne(String email) {
        return userRepository.findOne(email);
    }

    public User findByEmail(String email) {
        return userRepository.findOne(email);
    }

    public boolean isUserPresent(String email) {
        User u = userRepository.findOne(email);
        if (u != null)
            return true;
        return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
