package sk.tsystems.jada.forum.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Admin extends Person {

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
	 * Implicit class constructor.
	 */
	public Admin() {

	}

	/**
	 * 
	 * Class constructor using fields.
	 * 
	 * @param personName
	 * @param password
	 * @param fullName
	 * @param email
	 * @param birthday
	 * @param deleteCommentPermission
	 * @param deleteUserPermission
	 * @param deleteTopicPermission
	 * @param activationUserPernmision
	 */
	public Admin(String personName, String password, String fullName, String email, Date birthday,
			boolean deleteCommentPermission, boolean deleteUserPermission, boolean deleteTopicPermission,
			boolean activationUserPernmision) {
		super(personName, password, fullName, email, birthday);
		this.deleteCommentPermission = deleteCommentPermission;
		this.deleteUserPermission = deleteUserPermission;
		this.deleteTopicPermission = deleteTopicPermission;
		this.activationUserPernmision = activationUserPernmision;
		setActive(true);
	}

	/**
	 * ********************************** ********GETTER & SETTER***********
	 * **********************************
	 */

	public boolean isDeleteCommentPermission() {
		return deleteCommentPermission;
	}

	public void setDeleteCommentPermission(boolean deleteCommentPermission) {
		this.deleteCommentPermission = deleteCommentPermission;
	}

	public boolean isDeleteUserPermission() {
		return deleteUserPermission;
	}

	public void setDeleteUserPermission(boolean deleteUserPermission) {
		this.deleteUserPermission = deleteUserPermission;
	}

	public boolean isDeleteTopicPermission() {
		return deleteTopicPermission;
	}

	public void setDeleteTopicPermission(boolean deleteTopicPermission) {
		this.deleteTopicPermission = deleteTopicPermission;
	}

	public boolean isActivationUserPernmision() {
		return activationUserPernmision;
	}

	public void setActivationUserPernmision(boolean activationUserPernmision) {
		this.activationUserPernmision = activationUserPernmision;
	}

}
