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
	 *            String representation of SuperAdmin username
	 * @param password
	 *            String representation of SuperAdmin password
	 * @param fullName
	 *            String representation of SuperAdmin fullname
	 * @param email
	 *            String representation of SuperAdmin email address
	 * @param birthday
	 *            Date format of SuperADmins birthDate
	 */
	public SuperAdmin(String personName, String password, String fullName, String email, Date birthday) {
		super(personName, password, fullName, email, birthday);
		this.activationUserPernmision = true;
		this.deleteCommentPermission = true;
		this.deleteTopicPermission = true;
		this.deleteUserPermission = true;
		setActive(true);
	}

	/**
	 * Constructor without parameters
	 */
	public SuperAdmin() {
		super();
	}

	/**
	 * Return true if SuperAdmins permission for deleting comments is true
	 * 
	 * @return boolean result of deleteComment permission for current SuperAdmin
	 */
	public boolean isDeleteCommentPermission() {
		return deleteCommentPermission;
	}

	/**
	 * Return true if SuperAdmins permission for deleting users is true
	 * 
	 * @return boolean result of deleteUser permission for current SuperAdmin
	 */
	public boolean isDeleteUserPermission() {
		return deleteUserPermission;
	}

	/**
	 * Return true if SuperAdmins permission for deleting topic is true
	 * 
	 * @return boolean result of deleteTopic permission for current SuperAdmin
	 */
	public boolean isDeleteTopicPermission() {
		return deleteTopicPermission;
	}

	/**
	 * Return true if SuperAdmins permission for activationUser is true
	 * 
	 * @return boolean result of activate user permission for current SuperAdmin
	 */
	public boolean isActivationUserPernmision() {
		return activationUserPernmision;
	}

}
