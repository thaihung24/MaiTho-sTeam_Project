package com.k19.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.k19.controllers.register;

import net.bytebuddy.description.annotation.AnnotationDescription.Latent;

@Entity
@Table(name="users")
public class Users {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;
	private String code;
	private String firstName;
	private String lastName;
	private String gentle;
	private String email;
	private String password;
	private String contact;
    public Users() {
		super();
		code = "";
		email = "";
		password = "";
		firstName="";
		lastName="";
		contact="";
		gentle="";
	}
	
	public Users(String code,String firstName,String lastName,String gentle, String email, String password,String contact) {
		super();
		this.code = code;
		this.firstName=firstName;
		this.lastName=lastName;
		this.gentle=gentle;
		this.email = email;
		this.password = password;
		this.contact=contact;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setGentle(String gentle){
		this.gentle=gentle;
	}
	public String getGentle(){
		return this.gentle;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return this.code;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setContact(String contact){
		this.contact=contact;
	}
	public String getContact(){
		return this.contact;
	}
}
