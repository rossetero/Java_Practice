package com.github.rossetero.app;

import com.github.rossetero.models.ChatRoom;
import com.github.rossetero.models.Message;
import com.github.rossetero.models.User;
import com.github.rossetero.repositories.MessagesRepository;
import com.github.rossetero.repositories.MessagesRepositoryJdbcImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.annotation.processing.Messager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class DBRunner {
    private static HikariDataSource dataSource;

    public DBRunner() {
        try {
            HikariConfig config = new HikariConfig("src/main/resources/database.properties");
            dataSource = new HikariDataSource(config);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        MessagesRepository msgRepository = new MessagesRepositoryJdbcImpl(dataSource);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a message ID");
            String input = sc.nextLine();
            if ("q".equals(input)) {
                break;
            } else {
                try {
                    long id = Long.parseLong(input);
                    Optional<Message> message = msgRepository.findById(id);
                    if (message.isPresent()) {
                        System.out.println(message.get());
                    } else {
                        System.out.println("Message with id '" + id + "' not found");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input");
                }
            }
        }

        dataSource.close();
    }

    public void insertMessage(Long authorId, Long roomId, String text) {
        MessagesRepository msgRepository = new MessagesRepositoryJdbcImpl(dataSource);
//        User author = msgRepository.findUserById(userId);
//        Chatroom room = msgRepository.findChatroomById(roomId);
//        if (author == null || room == null) {
//            throw new NotSavedSubEntityException();
//        }
        User creator = new User(authorId, "user", "user");
        User author = creator;
        ChatRoom room = new ChatRoom(roomId, "room", author);
        Message message = new Message(null, author, room, text, LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        messagesRepository.save(message);
        System.out.println(message.getId());
    }

    public void editMessage(Long id, String text) {
        MessagesRepository msgRepository = new MessagesRepositoryJdbcImpl(dataSource);
        Optional<Message> message = msgRepository.findById(id);
        message.ifPresentOrElse(m -> {
            m.setText(text);
            msgRepository.update(m);
        }, () -> System.out.println("No such message"));
    }

}

