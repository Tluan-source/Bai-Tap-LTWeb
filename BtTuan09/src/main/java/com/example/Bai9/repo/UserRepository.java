package com.example.Bai9.repo;

import com.example.Bai9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {}
