package com.github.rossetero.repositories;

import com.github.rossetero.models.Message;

import java.util.Optional;

public interface MessagesRepository {
    Optional<Message> findById(Long id);
    void save(Message message);
    void update(Message message);
}
