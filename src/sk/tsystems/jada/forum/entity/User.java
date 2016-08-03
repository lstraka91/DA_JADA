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
public class User {

	/**
	 * Identifies user.
	 */
	@Id
	@GeneratedValue
	@Column(name = "ID_USER")
	private int idUser;

	/**
	 * User name.
	 */
	@Column(name = "user_Name")
	private String userName;

	/**
	 * Password of user.
	 */
	private String password;

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
	public User() {

	}

	/**
	 * Class constructor using fields.
	 */
	public User(String userName, String password, String email, Date birthday) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.registrationDate = new Date(System.currentTimeMillis());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", birthday=" + birthday + ", registrationDate=" + registrationDate + ", active=" + active + "]";
	}

}
