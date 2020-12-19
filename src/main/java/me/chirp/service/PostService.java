package me.chirp.service;

import me.chirp.model.Post;
import me.chirp.model.PostDTO;
import me.chirp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void addPost(PostDTO postDTO){

    }

    public List<PostDTO> getAllPosts(){
        return null;
    }
}
