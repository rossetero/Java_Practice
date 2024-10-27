package org.example.app;

import org.example.config.AppConfig;
import org.example.model.User;
import org.example.repositories.UsersRepository;
import org.example.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UsersRepository ur = context.getBean("usersRepositoryTemplateImpl",UsersRepository.class);
//        User u=new User(null,"john doe", "good2@site.ru","12345");
//        ur.save(u);
//        System.out.println(ur.findAll());
        UsersService usersService = context.getBean("usersServiceImpl",UsersService.class);
        usersService.signUp("Dmitry","rossetero@github.com");
    }
}