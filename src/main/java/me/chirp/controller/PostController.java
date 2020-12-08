package me.chirp.controller;

import me.chirp.model.PostDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping
    public void addPost(PostDTO post){
        //do smt with it
    }

}
