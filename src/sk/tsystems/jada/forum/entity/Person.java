/**
 * @author Branislav Popadiè
 * */
package sk.tsystems.jada.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import sk.tsystems.jada.forum.entity.services.PersonService;

@Entity
public class Person {

	/**
	 * Identifies user.
	 */
	@Id
	@GeneratedValue
	@Column(name = "ID_PERSON")
	private int idPerson;

	/**
	 * User name.
	 */
	@Column(name = "PERSON_NAME")
	private String personName;

	/**
	 * Password of user.
	 */
	private String password;

	/**
	 * Full name of user.
	 */
	private String fullName;

	/**
	 * User email.
	 */
	private String email;

	/**
	 * Users date of birth.
	 */
	private Date birthday;

	/**
	 * Date of registration user. Constructor sets this to current system date.
	 */
	@Column(name = "registration_Date")
	private Date registrationDate;

	/**
	 * Boolean value set by administrator to accept users registration.
	 */
	private boolean active;

	/**
	 * Implicit class constructor.
	 */
	public Person() {

	}

	/**
	 * Class constructor using fields.
	 * 
	 * @param personName
	 * @param password
	 * @param email
	 * @param birthday
	 */
	public Person(String personName, String password, String fullName, String email, Date birthday) {
		super();
		this.personName = personName;
		this.password = PersonService.encryptPassword(password);
		this.fullName = fullName;
		this.email = email;
		this.birthday = birthday;
		this.registrationDate = new Date(System.currentTimeMillis());
	}

	/********************************************************************************************************
	 ********************************** Getters and setters for fields **************************************
	 ********************************************************************************************************/

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = PersonService.encryptPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", personName=" + personName + ", password=" + password + ", fullName="
				+ fullName + ", email=" + email + ", birthday=" + birthday + ", registrationDate=" + registrationDate
				+ ", active=" + active + "]";
	}

}
