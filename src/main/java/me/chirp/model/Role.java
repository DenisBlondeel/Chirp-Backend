package me.chirp.model;

public class Role {

    private final String name;
    private String id;

    public Role (String name, String id){
        this.name = name;
        this.id = id;
    }

    public String geName(){
        return name;
    }

    public String getId() {
        return id;
    }
}
