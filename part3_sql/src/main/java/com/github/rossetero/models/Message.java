package com.github.rossetero.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long id;
    private final User author;
    private final ChatRoom room;
    private String text;
    private final LocalDateTime dateTime;

    public Message(Long id, User author, ChatRoom room, String text,LocalDateTime dateTime) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public User getAuthor() {
        return author;
    }

    public ChatRoom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text=text;
    }

    public LocalDateTime getDateTime() { return dateTime; }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null|| getClass()!=other.getClass()) return false;
        Message otherUser = (Message) other;
        return Objects.equals(this.id, otherUser.id)
                && Objects.equals(this.author, otherUser.author)
                && Objects.equals(this.room, otherUser.room)
                && Objects.equals(this.text, otherUser.text)
                && Objects.equals(this.dateTime, otherUser.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, dateTime);
    }

    @Override
    public String toString() {
        return "Message : {" +
                "\nid=" + id +
                ",\nauthor=" + (author != null ? author : "null") +
                ",\nroom=" + (room != null? room : "null") +
                ",\ntext=\"" + text + '"' +
                ",\ndataTime=" + dateTime.format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm")) +
                "\n}";
    }
}