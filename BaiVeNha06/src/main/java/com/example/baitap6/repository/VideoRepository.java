package com.example.baitap6.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.baitap6.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    
    List<Video> findByTitleContaining(String title);
    
    List<Video> findByDescriptionContaining(String description);
    
    Page<Video> findByTitleContaining(String title, Pageable pageable);
    
    Page<Video> findByDescriptionContaining(String description, Pageable pageable);
    
    @Query("SELECT v FROM Video v WHERE v.category.id = :categoryId")
    List<Video> findByCategoryId(@Param("categoryId") Integer categoryId);
    
    @Query("SELECT v FROM Video v WHERE v.category.id = :categoryId")
    Page<Video> findByCategoryId(@Param("categoryId") Integer categoryId, Pageable pageable);
    
    @Query("SELECT v FROM Video v WHERE v.isActive = true")
    List<Video> findActiveVideos();
    
    @Query("SELECT v FROM Video v WHERE v.isActive = true")
    Page<Video> findActiveVideos(Pageable pageable);
}
