package tn.esprit.spring.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Claims implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long idClaim;
	private String Claim_Descrip;
	private File Documents;
	@Temporal(TemporalType.DATE)
	private Date Claim_date;
	@Enumerated(EnumType.STRING)
	Stateclaim Stateclaim;
	@Enumerated(EnumType.STRING)
	Claimtype claimtype;
	public Long getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}
	public String getClaim_Descrip() {
		return Claim_Descrip;
	}
	public void setClaim_Descrip(String claim_Descrip) {
		Claim_Descrip = claim_Descrip;
	}
	public File getDocuments() {
		return Documents;
	}
	public void setDocuments(File documents) {
		Documents = documents;
	}
	public Date getClaim_date() {
		return Claim_date;
	}
	public void setClaim_date(Date claim_date) {
		Claim_date = claim_date;
	} 
	
	



	@OneToOne
	private Ratingclaim ratingclaim;
	@ManyToOne
	private User user;
	
	public Ratingclaim getRatingclaim() {
		return ratingclaim;
	}
	public void setRatingclaim(Ratingclaim ratingclaim) {
		this.ratingclaim = ratingclaim;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
