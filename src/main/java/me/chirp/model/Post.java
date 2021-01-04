package me.chirp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private UUID id;

    private String content;

    private boolean publicPost;

    public Post(){

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

    public UUID getId() {
        return id;
    }
}
