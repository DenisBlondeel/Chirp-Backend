package me.chirp.service;

import me.chirp.mapper.PostMapper;
import me.chirp.model.Post;
import me.chirp.model.PostDTO;
import me.chirp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void addPost(PostDTO postDTO){
        postRepository.save(PostMapper.dtoToPost(postDTO));
    }

    public List<PostDTO> getAllPosts(){

        return postRepository.findAll()
                .stream()
                .map(PostMapper::postToDTO)
                .collect(Collectors.toList());
    }
}
