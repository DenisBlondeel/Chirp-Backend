package me.chirp.model;

import java.util.List;
import java.util.UUID;

public class UserDTO {

    private String username;

    private UUID kcId;

    private String firstName;
    private String lastName;
    private String email;
    private List<PostDTO> postDTOS;

    public UserDTO(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<PostDTO> getPostDTOS() {
        return postDTOS;
    }

    public void setPostDTOS(List<PostDTO> postDTOS) {
        this.postDTOS = postDTOS;
    }

    public UUID getKcId() {
        return kcId;
    }

    public void setKcId(UUID kcId) {
        this.kcId = kcId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
