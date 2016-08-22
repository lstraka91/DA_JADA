/**
 * @author Branislav Popadiè
 * */
package sk.tsystems.jada.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.birthday = birthday;
		this.registrationDate = new Date(System.currentTimeMillis());
	}

	/********************************************************************************************************
	 ********************************** Getters and setters for fields **************************************
	 ********************************************************************************************************/

	/**
	 * return id of Person
	 * 
	 * @return id value of Person
	 */
	public int getIdPerson() {
		return idPerson;
	}

	/**
	 * set person value of ident
	 * 
	 * @param idPerson
	 *            person value of id
	 */
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * return person userName
	 * 
	 * @return String of person username
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * set the new person userName
	 * 
	 * @param personName
	 *            String of new person name to Person object
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * return password of Person
	 * 
	 * @return password of Person
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set the new password for Person
	 * 
	 * @param password
	 *            new password for Person object
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * return Persons email address
	 * 
	 * @return String representation of email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set new email address to Person
	 * 
	 * @param email
	 *            string representation of new email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * returns date of birthday
	 * 
	 * @return date of Person birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * set Person birthday
	 * 
	 * @param birthday
	 *            new Date for persons birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * return date of registration user
	 * 
	 * @return date of registration user
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * set new Registration date of Person
	 * 
	 * @param registrationDate
	 *            new Date of registration
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * boolean representation if Person is activated or no
	 * 
	 * @return true or false if Person is activated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * set activate property
	 * 
	 * @param active
	 *            boolean representation if person is or no activated
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * return full name of Person
	 * 
	 * @return full name of Person
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * set new fullName of person
	 * 
	 * @param fullName
	 *            new full name for Person
	 */
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
