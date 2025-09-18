package com.example.baitap6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.baitap6.entity.AppUser;

public interface UserService {
    
    List<AppUser> findAll();
    
    Optional<AppUser> findById(Integer id);
    
    AppUser save(AppUser user);
    
    void deleteById(Integer id);
    
    List<AppUser> findByUsernameContaining(String username);
    
    List<AppUser> findByFullnameContaining(String fullname);
    
    List<AppUser> findByEmailContaining(String email);
    
    Page<AppUser> findByUsernameContaining(String username, Pageable pageable);
    
    Page<AppUser> findByFullnameContaining(String fullname, Pageable pageable);
    
    Page<AppUser> findByEmailContaining(String email, Pageable pageable);
    
    AppUser findByUsername(String username);
    
    AppUser findByEmail(String email);
}
