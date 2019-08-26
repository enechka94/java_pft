package ru.stqa.pft.mantis.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "mantis_user_table")
public class UsersData {

    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "username")
    @Type(type = "string")
    private String username;

    @Column(name = "realname")
    @Type(type = "string")
    private String realname;

    @Column(name = "email")
    @Type(type = "string")
    private String email;

    public UsersData withId(int id) {
        this.id = id;
        return this;
    }

    public UsersData withUsername(String username) {
        this.username = username;
        return this;
    }

    public UsersData withRealname(String realname) {
        this.realname = realname;
        return this;
    }

    public UsersData withEmail(String email) {
        this.email = email;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersData usersData = (UsersData) o;
        return id == usersData.id &&
                Objects.equals(username, usersData.username) &&
                Objects.equals(email, usersData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }

    @Override
    public String toString() {
        return "UsersData{" +
                "id=" + id +
                ", inAsUser='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
