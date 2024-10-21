package com.github.rossetero.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private final Long id;
    private String login;
    private String password;
    private ArrayList<ChatRoom> createdChatRooms;
    private ArrayList<ChatRoom> participatedChatRooms;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        createdChatRooms = new ArrayList<>();
        participatedChatRooms = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<ChatRoom> getCreatedRooms() {
        return createdChatRooms;
    }

    public ArrayList<ChatRoom> getParticipatedChatRooms() {
        return participatedChatRooms;
    }

    public void setCreatedChatRooms(ArrayList<ChatRoom> createdChatRooms) {
        this.createdChatRooms = createdChatRooms;
    }

    public void setParticipatedChatRooms(ArrayList<ChatRoom> participatedChatRooms) {
        this.participatedChatRooms = participatedChatRooms;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object other){
        if(this==other) return true;
        if(other==null||getClass()!=other.getClass()) return false;
        User otherUser = (User) other;
        return Objects.equals(this.id,otherUser.id)
                && Objects.equals(this.login, otherUser.login)
                && Objects.equals(this.password, otherUser.password)
                && Objects.equals(this.createdChatRooms, otherUser.createdChatRooms)
                && Objects.equals(this.participatedChatRooms, otherUser.participatedChatRooms);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,login,password);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", login=\"" + login + '"' +
                ", password=\"" + password + '"' +
                ", createdRooms=" + (!createdChatRooms.isEmpty()  ? createdChatRooms : "null") +
                ", rooms=" + (!participatedChatRooms.isEmpty()  ? participatedChatRooms : "null") +
                '}';
    }
}
