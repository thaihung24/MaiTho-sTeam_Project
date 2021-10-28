package com.k19.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "member")
@Table(name = "member")
public class memberJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    // @Column(name = "FNAME")
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String contact;

    private String gentle;
    private String fullName;
    // profile
    private String avt;
    // create_on and last_login are hidden

    public memberJPA() {
        firstName = "";
        lastName = "";
        username = "";
        password = "";
        email = "";
        contact = "";
        gentle = "";
        fullName = "";
        avt = "";
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getGentle() {
        return this.gentle;
    }

    public void setGentle(final String gentle) {
        this.gentle = gentle;
    }
}
