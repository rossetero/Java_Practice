package org.example.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class User {
    private Long id;
    private String email;
    private String name;
    private String password;

    public User(Long id,String name, String email, String password) {
        this.id = id;
        this.email = email;
        this.name=name;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email,name, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        User other = (User) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.email, other.email)
                && Objects.equals(this.name,other.name)
                && Objects.equals(this.password, other.password);
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: " + name +
                ", email: " + email +
                ", password: " + password +
                '}';
    }

}
