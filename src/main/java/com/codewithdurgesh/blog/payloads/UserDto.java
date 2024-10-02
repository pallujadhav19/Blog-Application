package com.codewithdurgesh.blog.payloads;

import org.hibernate.validator.constraints.Email;

import com.codewithdurgesh.blog.entities.User;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
public class UserDto {
	
	private int id;
	
	@NotEmpty //(combination of blank not null)
	@Size(min=4, message="username must be minimum of 4 characters!!")
	private String name;
	
	@Email(message="Email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="PASSWORD MUST BE MINIMUM OF 3 CHAR AND MAXMIMU OF 10 CHARACTER!!")
	private String password;
	
	@NotEmpty
	private String about;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	

}
