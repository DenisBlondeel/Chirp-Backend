package me.chirp.configuration;

import me.chirp.model.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {

    private Role userRole;
    private Role newUserRole;

    public RoleConfig(@Value("${role.user.id}") String userId, @Value("${role.new_user.id}") String newUserId){
         userRole = new Role("user", userId);
         newUserRole = new Role("new_user", newUserId);
    }

    public Role getRole(String name){

        if(name.equals("user")){
            return userRole;
        }

        else return newUserRole;

    }
}
