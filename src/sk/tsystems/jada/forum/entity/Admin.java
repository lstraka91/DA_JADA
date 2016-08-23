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
	 * Boolean variable for activation user
	 */
	private boolean activationUserPernmision;

	/**
	 * Implicit class constructor.
	 */
	public Admin() {

	}

	/**
	 * Class constructor using fields.
	 * 
	 * @param personName
	 *            name of current administrator
	 * @param password
	 *            password of current administrator
	 * @param fullName
	 *            full name of current administrator
	 * @param email
	 *            e-mail of current administrator
	 * @param birthday
	 *            birthday of current administrator
	 * @param deleteCommentPermission
	 *            permission for delete and edit topic
	 * @param deleteUserPermission
	 *            permission for delete users
	 * @param deleteTopicPermission
	 *            permission for delete and edit topic
	 * @param activationUserPernmision
	 *            permission for activation users
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
	 * Method return true if administrator has permission for delete and edit
	 * comments otherwise return false
	 * 
	 * @return deleteCommentPermission variable of type boolean
	 */
	public boolean isDeleteCommentPermission() {
		return deleteCommentPermission;
	}

	/**
	 * Sets permission delete and edit comments for administrator
	 * 
	 * @param deleteCommentPermission
	 *            variable of type boolean
	 */
	public void setDeleteCommentPermission(boolean deleteCommentPermission) {
		this.deleteCommentPermission = deleteCommentPermission;
	}

	/**
	 * Method return true if administrator has permission for delete users
	 * otherwise return false
	 * 
	 * @return deleteUserPermission variable of type boolean
	 */
	public boolean isDeleteUserPermission() {
		return deleteUserPermission;
	}

	/**
	 * Sets permission delete users for administrator
	 * 
	 * @param deleteUserPermission
	 *            variable of type boolean
	 */
	public void setDeleteUserPermission(boolean deleteUserPermission) {
		this.deleteUserPermission = deleteUserPermission;
	}

	/**
	 * Method return true if administrator has permission for delete and edit
	 * topics otherwise return false
	 * 
	 * @return deleteTopicPermission variable of type boolean
	 */
	public boolean isDeleteTopicPermission() {
		return deleteTopicPermission;
	}

	/**
	 * Sets permission delete and edit topics for administrator
	 * 
	 * @param deleteTopicPermission
	 *            variable of type boolean
	 */
	public void setDeleteTopicPermission(boolean deleteTopicPermission) {
		this.deleteTopicPermission = deleteTopicPermission;
	}

	/**
	 * Method return true if administrator has permission for activation users
	 * otherwise return false
	 * 
	 * @return activationUserPernmision variable of type boolean
	 */
	public boolean isActivationUserPernmision() {
		return activationUserPernmision;
	}

	/**
	 * Sets permission activation users for administrator
	 * 
	 * @param activationUserPernmision
	 *            variable of type boolean
	 */
	public void setActivationUserPernmision(boolean activationUserPernmision) {
		this.activationUserPernmision = activationUserPernmision;
	}

}
