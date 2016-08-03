package sk.tsystems.jada.forum.entity;

import java.util.Date;

public abstract class User {

	private int idUser;

	private String userName;
	private String password;
	private String email;
	private Date birthday;
	private Date registration;
	private boolean active;

	public User() {
	}

}
