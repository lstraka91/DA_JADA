package sk.tsystems.jada.forum.entity.services;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Person;

public class PersonService {

	/**
	 * 
	 * @param idPerson
	 * @return Object Person with parameter idPerson.
	 */
	private Person getPerson(int idPerson) {
		EntityManager em = JpaHelper.getEntityManager();
		return em.find(Person.class, idPerson);
	}

	private Person getPersonByName(String personName) {
		int id = 0;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select idPerson from Person p where p.personName = :personName");

		query.setParameter("personName", personName);
		if (!query.getResultList().isEmpty()) {
			id = (int) query.getResultList().get(0);
			return getPerson(id);
		} else {
			return null;
		}
	}

//	public Person getPersonWithCheck(String personName) {
		// int
//	}

	// public Player checkPlayer(String playerName) {
	// int idPlayer = playerId(playerName);
	// System.out.println(idPlayer);
	// if (idPlayer != 0) {
	// return getPlayer(idPlayer);
	// } else {
	// Player playerRes = new Player(playerName);
	// insertPlayer(playerRes);
	// return playerRes;
	// }
	// }
	//
	// private int playerId(String playerName) {
	// int id = 0;
	// EntityManager em = JpaHelper.getEntityManager();
	// Query query = em.createQuery("select idPlayer from Player p where
	// p.playerName = :name");
	// query.setParameter("name", playerName);
	// if (!query.getResultList().isEmpty()) {
	// id = (int) query.getResultList().get(0);
	// }
	// return id;
	// }
	//
	// private void insertPlayer(Player player) {
	// JpaHelper.beginTransaction();
	// EntityManager em = JpaHelper.getEntityManager();
	// em.persist(player);
	// JpaHelper.commitTransaction();
	// }

}
