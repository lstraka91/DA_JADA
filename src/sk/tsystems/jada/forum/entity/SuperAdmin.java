package sk.tsystems.jada.forum.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class SuperAdmin extends Person {

	/**
	 * Boolean variable for deleting comment permission
	 */
	private boolean deleteCommentPermission;

	/**
	 * Boolean variable for deleting user permission
	 */
	private boolean deleteUserPermission;

	/**
	 * Boolean variable for deleting topic permission
	 */
	private boolean deleteTopicPermission;

	/**
	 * Boolean variable for activation of user
	 */
	private boolean activationUserPernmision;

	/**
	 * Contstructor for Super Administrator, that is equal to Admin entity but
	 * could manage others administrator and all permision are default set to
	 * true
	 * 
	 * @param personName
	 * @param password
	 * @param fullName
	 * @param email
	 * @param birthday
	 */
	public SuperAdmin(String personName, int password, String fullName, String email, Date birthday) {
		super(personName, password, fullName, email, birthday);
		this.activationUserPernmision = true;
		this.deleteCommentPermission = true;
		this.deleteTopicPermission = true;
		this.deleteUserPermission = true;
		setActive(true);
	}
	

	
	public SuperAdmin() {
		super();
			}



	public boolean isDeleteCommentPermission() {
		return deleteCommentPermission;
	}

	public boolean isDeleteUserPermission() {
		return deleteUserPermission;
	}

	public boolean isDeleteTopicPermission() {
		return deleteTopicPermission;
	}

	public boolean isActivationUserPernmision() {
		return activationUserPernmision;
	}
	
}
