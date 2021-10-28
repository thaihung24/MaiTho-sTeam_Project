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
    @Column(name = "avtsrc")
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
        avt = "https://scontent.fsgn5-10.fna.fbcdn.net/v/t1.6435-1/cp0/p50x50/242671555_1290676461378883_7058234362211864781_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=7206a8&_nc_ohc=B7XwOqgR6i4AX-5GZcU&_nc_ht=scontent.fsgn5-10.fna&oh=2579620110dcc27bc686497f21eb7a6f&oe=619B779F";
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
