package com.example.SpringSecurity.repositories;

import com.example.SpringSecurity.entities.StakeholderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StakeholderRepository extends JpaRepository<StakeholderInfo,Integer> {
}
