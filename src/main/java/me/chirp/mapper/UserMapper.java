package me.chirp.mapper;

import me.chirp.model.Post;
import me.chirp.model.PostDTO;
import me.chirp.model.User;
import me.chirp.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User dtoToUser(UserDTO userDTO) {

        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setKcId(userDTO.getKcId());
        user.setUsername(userDTO.getUsername());

        List<Post> posts = new ArrayList<>();

        if (userDTO.getPostDTOS() != null) {
            for (PostDTO postDTO : userDTO.getPostDTOS()) {
                posts.add(PostMapper.dtoToPost(postDTO));
            }
            user.setPosts(posts);

        }
        return user;
    }

    public static UserDTO userToDto(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setKcId(user.getKcId());

        List<PostDTO> postDTOs = new ArrayList<>();

        if (user.getPosts() != null) {
            for (Post post : user.getPosts()) {
                postDTOs.add(PostMapper.postToDTO(post));
            }
            userDTO.setPostDTOS(postDTOs);
        }
        return userDTO;

    }
}
