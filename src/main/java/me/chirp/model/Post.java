package me.chirp.model;

import javax.persistence.*;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private User user;

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

    public Long getId() {
        return id;
    }

    public void setUser(User author) {
        this.user = author;
    }

    public User getUser() {
        return user;
    }
}
