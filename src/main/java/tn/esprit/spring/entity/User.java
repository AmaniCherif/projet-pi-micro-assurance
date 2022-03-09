package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

public class User implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)

	private Long idUser;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	private String firstname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	private String lastname;
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	private String sex;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	/*private Long cin;
	public Long getCin() {
		return cin;

	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	public Date getBirthdate() {
		return birthdate;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	*/
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private int postalCode;
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	private String job;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String confirmPassword;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	private Long phoneNumber;
    public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	private String departement;
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	@Enumerated(EnumType.STRING)
	private RoleUser roleUser;
	@Enumerated(EnumType.STRING)
	private StatusUser statusUser;
	@Enumerated(EnumType.STRING)
	private CityUser cityUser;
	@OneToMany(mappedBy="user")
	private Set<Investement>investements;
	@OneToMany(mappedBy="user")
	private Set<ContractRequest>contractRequest;
	@OneToMany(mappedBy="user")
	private Set<ContractOffer>ContractOffer;
	@OneToMany(mappedBy="user")
	private Set<Claim_report>claimsReport;




	



}

