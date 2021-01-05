package me.chirp.model;

public class PostDTO {

    private String content;
    private boolean publicPost;

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
}
