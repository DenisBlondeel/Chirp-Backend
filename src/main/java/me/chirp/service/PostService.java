package me.chirp.service;

import me.chirp.mapper.PostMapper;
import me.chirp.model.Post;
import me.chirp.model.PostDTO;
import me.chirp.model.User;
import me.chirp.repository.PostRepository;
import me.chirp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void addPost(PostDTO postDTO){
        Post post = PostMapper.dtoToPost(postDTO);

        postRepository.save(post);
    }

    public List<PostDTO> getAllPosts(){

        return postRepository.findAllByOrderByIdDesc()
                .stream()
                .map(PostMapper::postToDTO)
                .collect(Collectors.toList());
    }
}
