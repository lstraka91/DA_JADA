package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.Commentary;

public class AdminService {

	/**
	 * Show all admin
	 * 
	 * @return
	 */
	public ArrayList<Admin> showAllAdmins() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT a  from Admin a ");
		ArrayList<Admin> AdminList = (ArrayList<Admin>) query.getResultList();
		return AdminList;

	}

	/**
	 * 
	 * update admin permissions
	 * 
	 * @param admin
	 * @param deleteCommentPermission
	 * @param deleteUserPermission
	 * @param deleteTopicPermission
	 * @param activationUserPernmision
	 */
	public void permissionUpdate(Admin admin, boolean deleteCommentPermission, boolean deleteUserPermission,
			boolean deleteTopicPermission, boolean activationUserPernmision) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		admin = em.find(Admin.class, admin);
		admin.setActivationUserPernmision(activationUserPernmision);
		admin.setDeleteCommentPermission(deleteCommentPermission);
		admin.setDeleteTopicPermission(deleteTopicPermission);
		admin.setDeleteUserPermission(deleteUserPermission);
		JpaHelper.commitTransaction();

	}

	/**
	 * 
	 * find admin by name
	 * 
	 * @param personName
	 * @return
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
