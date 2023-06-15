package com.stein.blog.controller;

import com.stein.blog.entity.Post;
import com.stein.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {
    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/posts")
    public List<Post> posts() {
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    public void publishPost(@RequestBody Post post) {
        if (post.getDateCreated() == null) {
            post.setDateCreated(new Date());
        }
        postService.insert(post);
    }
}
