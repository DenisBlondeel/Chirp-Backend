package me.chirp.controller;

import me.chirp.model.PostDTO;
import me.chirp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post")
    public void addPost(@RequestBody PostDTO post){
        postService.addPost(post);
    }

    @GetMapping("/post")
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

}
