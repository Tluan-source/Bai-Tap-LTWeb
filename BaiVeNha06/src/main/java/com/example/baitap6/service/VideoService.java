package com.example.baitap6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.baitap6.entity.Video;

public interface VideoService {
    
    List<Video> findAll();
    
    Optional<Video> findById(Integer id);
    
    Video save(Video video);
    
    void deleteById(Integer id);
    
    List<Video> findByTitleContaining(String title);
    
    List<Video> findByDescriptionContaining(String description);
    
    Page<Video> findByTitleContaining(String title, Pageable pageable);
    
    Page<Video> findByDescriptionContaining(String description, Pageable pageable);
    
    List<Video> findByCategoryId(Integer categoryId);
    
    Page<Video> findByCategoryId(Integer categoryId, Pageable pageable);
    
    List<Video> findActiveVideos();
    
    Page<Video> findActiveVideos(Pageable pageable);
}
