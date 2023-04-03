package com.devmind.spring.model;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class User {
	private String userName;
	private String email;
	private String phone;
	private String birthDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
