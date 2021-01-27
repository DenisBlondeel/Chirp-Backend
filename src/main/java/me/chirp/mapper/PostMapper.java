package me.chirp.mapper;

import me.chirp.model.Post;
import me.chirp.model.PostDTO;
import me.chirp.model.User;
import me.chirp.model.UserDTO;

public class PostMapper {

    public static Post dtoToPost(PostDTO dto){
        Post post = new Post();
        User user = UserMapper.dtoToUser(dto.getUserDto());

        post.setContent(dto.getContent());
        post.setPublicPost(dto.isPublicPost());
        post.setUser(user);

        return post;
    }

    public static PostDTO postToDTO(Post post){
        PostDTO dto = new PostDTO();
        UserDTO user = new UserDTO();

        user.setFirstName(post.getUser().getFirstName());
        user.setLastName(post.getUser().getLastName());
        //userDTO.setEmail(post.getAuthor().getEmail());

        dto.setContent(post.getContent());
        dto.setPublicPost(post.isPublicPost());

        return dto;
    }
}
