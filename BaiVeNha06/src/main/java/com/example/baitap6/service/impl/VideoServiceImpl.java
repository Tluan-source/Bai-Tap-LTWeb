package com.example.baitap6.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.baitap6.entity.Video;
import com.example.baitap6.repository.VideoRepository;
import com.example.baitap6.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> findById(Integer id) {
        return videoRepository.findById(id);
    }

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void deleteById(Integer id) {
        videoRepository.deleteById(id);
    }

    @Override
    public List<Video> findByTitleContaining(String title) {
        return videoRepository.findByTitleContaining(title);
    }

    @Override
    public List<Video> findByDescriptionContaining(String description) {
        return videoRepository.findByDescriptionContaining(description);
    }

    @Override
    public Page<Video> findByTitleContaining(String title, Pageable pageable) {
        return videoRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<Video> findByDescriptionContaining(String description, Pageable pageable) {
        return videoRepository.findByDescriptionContaining(description, pageable);
    }

    @Override
    public List<Video> findByCategoryId(Integer categoryId) {
        return videoRepository.findByCategoryId(categoryId);
    }

    @Override
    public Page<Video> findByCategoryId(Integer categoryId, Pageable pageable) {
        return videoRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public List<Video> findActiveVideos() {
        return videoRepository.findActiveVideos();
    }

    @Override
    public Page<Video> findActiveVideos(Pageable pageable) {
        return videoRepository.findActiveVideos(pageable);
    }
}
