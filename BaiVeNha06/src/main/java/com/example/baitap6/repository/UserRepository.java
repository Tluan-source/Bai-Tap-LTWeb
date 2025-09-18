package com.example.baitap6.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.baitap6.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    
    List<AppUser> findByUsernameContaining(String username);
    
    List<AppUser> findByFullnameContaining(String fullname);
    
    List<AppUser> findByEmailContaining(String email);
    
    Page<AppUser> findByUsernameContaining(String username, Pageable pageable);
    
    Page<AppUser> findByFullnameContaining(String fullname, Pageable pageable);
    
    Page<AppUser> findByEmailContaining(String email, Pageable pageable);
    
    AppUser findByUsername(String username);
    
    AppUser findByEmail(String email);
}
