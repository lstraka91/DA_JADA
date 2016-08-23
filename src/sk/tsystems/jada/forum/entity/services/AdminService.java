package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Admin;

public class AdminService {

	/**
	 * Method for select all administrators from database
	 * 
	 * @return ArrayList of all administrators
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Admin> showAllAdmins() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT a  from Admin a ");
		ArrayList<Admin> AdminList = (ArrayList<Admin>) query.getResultList();
		return AdminList;

	}

	/**
	 * Method update all permissions for administrator in parameter
	 * 
	 * @param admin
	 *            object of type Admin which is updated
	 * @param deleteCommentPermission
	 *            variable of type boolean for permission delete and edit
	 *            comments
	 * @param deleteUserPermission
	 *            variable of type boolean for permission delete users
	 * @param deleteTopicPermission
	 *            variable of type boolean for permission delete and edit topics
	 * @param activationUserPernmision
	 *            variable of type boolean for permission activation users
	 * 
	 * @see Admin
	 */
	public void permissionUpdate(Admin admin, boolean deleteCommentPermission, boolean deleteUserPermission,
			boolean deleteTopicPermission, boolean activationUserPernmision) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		if (admin != null) {
			admin.setActivationUserPernmision(activationUserPernmision);
			admin.setDeleteCommentPermission(deleteCommentPermission);
			admin.setDeleteTopicPermission(deleteTopicPermission);
			admin.setDeleteUserPermission(deleteUserPermission);
			em.merge(admin);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method select administrator by personName
	 * 
	 * @param personName
	 *            for find administrator by name
	 * 
	 * @return admin object of type Admin
	 * 
	 * @see Admin
	 */
	public Admin findAdminByName(String personName) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT a  from Admin a where a.personName = :personName  ");
		query.setParameter("personName", personName);
		Admin admin = (Admin) query.getSingleResult();
		if (query.getSingleResult() != null) {
			return admin;
		} else {
			return null;
		}
	}
}
