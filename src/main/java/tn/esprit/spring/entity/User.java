  package tn.esprit.spring.entity;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity


public class User implements UserDetails {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)

	private Long idUser;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	@Email(message = "Username needs to be an email")
	@NotBlank(message = "username is required")
	@Column(unique = true)
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@NotBlank(message = "Please enter your firstname")
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

	private Long cin;


	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		cin = cin;
	}
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
  }

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
	@NotBlank(message = "Password field is required")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Transient
	
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
	private Date create_At;
	public Date getCreate_At() {
		return create_At;
	}
	public void setCreate_At(Date create_At) {
		this.create_At = create_At;
	}
	private Date update_At;
	public Date getUpdate_At() {
		return update_At;
	}
	public void setUpdate_At(Date update_At) {
		this.update_At = update_At;
	}
	/*
	 UserDetails interface methods
	 */
	@PrePersist
	protected void onCreate() { this.create_At = new Date(); }
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
	   return null;
	}
	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
	    return true;
	}
	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
	  return true;
	}
	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
	@PreUpdate
	protected void onUpdate() { this.update_At = new Date(); }
	@Enumerated(EnumType.STRING)
	private RoleUser roleUser;
	@Enumerated(EnumType.STRING)
	private StatusUser statusUser;
	@Enumerated(EnumType.STRING)
	private CityUser cityUser;
	@OneToMany(mappedBy="user")
	///private Set<Investement>investements;
	//@OneToMany(mappedBy="user")
	private Set<ContractRequest>contractRequest;
	@OneToMany(mappedBy="user")
	private Set<ContractOffer>ContractOffers;
	@OneToMany(mappedBy="user")
	private Set<Claim_report>claimsReport;

	public RoleUser getRoleUser() {
		return roleUser;
	}
	
	

	public StatusUser getStatusUser() {
		return statusUser;
	}
	public void setStatusUser(StatusUser statusUser) {
		this.statusUser = statusUser;
	}
	public CityUser getCityUser() {
		return cityUser;
	}
	public void setCityUser(CityUser cityUser) {
		this.cityUser = cityUser;
	}
	public void setRoleUser(RoleUser roleUser) {
		this.roleUser = roleUser;
	}

	public List<RoleUser> getRoleList(){

		List<RoleUser> list = new ArrayList<>();
		List<RoleUser> l =  Arrays.asList(RoleUser.values());
		list.addAll(l);
		return list;
	}
}
