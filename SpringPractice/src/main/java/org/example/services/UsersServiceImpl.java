package org.example.services;

import org.example.model.User;
import org.example.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UsersServiceImpl implements UsersService{
    private UsersRepository<User> ur;
    @Autowired
    public UsersServiceImpl(@Qualifier("usersRepositoryTemplateImpl") UsersRepository<User> ur){
        this.ur=ur;
    }

    @Override
    public String signUp(String name, String email) {
        String pswd = UUID.randomUUID().toString();
        User u = new User(null, name,email,pswd);
        ur.save(u);
        return pswd;
    }
}
