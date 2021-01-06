package me.chirp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDTO {

    private String content;
    private boolean publicPost;

    @JsonProperty
    private UserDTO user;

    public PostDTO(){

    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public boolean isPublicPost() {
        return publicPost;
    }

    public void setPublicPost(boolean publicPost) {
        this.publicPost = publicPost;
    }

    public UserDTO getProfileDTO() {
        return user;
    }

    public void setProfileDTO(UserDTO userDTO) {
        this.user = userDTO;
    }

}
