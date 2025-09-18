package com.example.baitap6.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.baitap6.entity.AppUser;
import com.example.baitap6.repository.UserRepository;
import com.example.baitap6.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<AppUser> findByUsernameContaining(String username) {
        return userRepository.findByUsernameContaining(username);
    }

    @Override
    public List<AppUser> findByFullnameContaining(String fullname) {
        return userRepository.findByFullnameContaining(fullname);
    }

    @Override
    public List<AppUser> findByEmailContaining(String email) {
        return userRepository.findByEmailContaining(email);
    }

    @Override
    public Page<AppUser> findByUsernameContaining(String username, Pageable pageable) {
        return userRepository.findByUsernameContaining(username, pageable);
    }

    @Override
    public Page<AppUser> findByFullnameContaining(String fullname, Pageable pageable) {
        return userRepository.findByFullnameContaining(fullname, pageable);
    }

    @Override
    public Page<AppUser> findByEmailContaining(String email, Pageable pageable) {
        return userRepository.findByEmailContaining(email, pageable);
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
