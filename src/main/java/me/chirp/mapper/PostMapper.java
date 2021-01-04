package me.chirp.mapper;

import me.chirp.model.Post;
import me.chirp.model.PostDTO;
import org.springframework.stereotype.Component;

public class PostMapper {

    public static Post dtoToPost(PostDTO dto){
        Post post = new Post();

        post.setContent(dto.getContent());
        post.setPublicPost(dto.isPublicPost());

        return post;
    }

    public static PostDTO postToDTO(Post post){
        PostDTO dto = new PostDTO();

        dto.setContent(post.getContent());
        dto.setPublicPost(post.isPublicPost());

        return dto;
    }
}
