package com.github.rossetero.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom {
    private final Long id;
    private String name;
    private User owner;
    private List<Message> messages;

    public ChatRoom(Long id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        messages = new ArrayList<Message>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if(other==null||getClass()!=other.getClass()) return false;
        ChatRoom otherChatRoom = (ChatRoom) other;
        return Objects.equals(this.id, otherChatRoom.id)
                && Objects.equals(this.name, otherChatRoom.name)
                && Objects.equals(this.owner, otherChatRoom.owner)
                && Objects.equals(this.messages, otherChatRoom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner);
    }

    @Override
    public String toString() {
        return "Chatroom {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + (owner != null ? owner.toString() : "null") +
                '}';
    }
}