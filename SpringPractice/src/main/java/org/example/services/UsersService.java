package org.example.services;

import org.springframework.stereotype.Component;


public interface UsersService {
    String signUp(String name, String email);
}