package com.example.baitap6.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.baitap6.entity.Category;
import com.example.baitap6.entity.Video;
import com.example.baitap6.service.CategoryService;
import com.example.baitap6.service.VideoService;

@Controller
@RequestMapping("admin/videos")
public class VideoAdminController {
    
    @Autowired
    VideoService videoService;
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("add")
    public String add(ModelMap model) {
        model.addAttribute("video", new Video());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/videos/add";
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @ModelAttribute("video") Video video) {
        if (video.getCreateDate() == null) {
            video.setCreateDate(new Date());
        }
        if (video.getViews() == null) {
            video.setViews(0);
        }
        if (video.getShares() == null) {
            video.setShares(0);
        }
        if (video.getIsActive() == null) {
            video.setIsActive(true);
        }
        videoService.save(video);
        model.addAttribute("message", "Video is saved!");
        return new ModelAndView("redirect:/admin/videos", model);
    }

    @RequestMapping("")
    public String list(ModelMap model) {
        List<Video> list = videoService.findAll();
        model.addAttribute("videos", list);
        return "admin/videos/list";
    }

    @GetMapping("edit/{videoId}")
    public String edit(ModelMap model, @PathVariable("videoId") int videoId) {
        Optional<Video> opt = videoService.findById(videoId);
        if (opt.isPresent()) {
            model.addAttribute("video", opt.get());
        } else {
            model.addAttribute("video", new Video());
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/videos/add";
    }

    @GetMapping("delete/{videoId}")
    public ModelAndView delete(ModelMap model, @PathVariable("videoId") int videoId) {
        videoService.deleteById(videoId);
        model.addAttribute("message", "Video is deleted!");
        return new ModelAndView("redirect:/admin/videos", model);
    }

    @RequestMapping("search")
    public String search(ModelMap model, @RequestParam(name="keyword", required = false) String keyword) {
        List<Video> list = null;
        if (StringUtils.hasText(keyword)) {
            list = videoService.findByTitleContaining(keyword);
            list.addAll(videoService.findByDescriptionContaining(keyword));
        } else {
            list = videoService.findAll();
        }
        model.addAttribute("videos", list);
        return "admin/videos/search";
    }
}
