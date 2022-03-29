package tn.esprit.spring.entity;

import java.util.Date;


import javax.persistence.Column;
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
public class Claims {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="idClaim")
	private Long idClaim;
	private String Claim_Descrip;
	private String Documents;
	@Temporal(TemporalType.DATE)
	private Date Claim_date;
	@Enumerated(EnumType.STRING)
	private Stateclaim Stateclaim;
	@Enumerated(EnumType.STRING)
	private Claimtype claimtype;
	
	@OneToOne
	
	private Ratingclaim ratingclaim ;
	
	public Claims() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	private User user;
	
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
	public String getDocuments() {
		return Documents;
	}
	public void setDocuments(String documents) {
		Documents = documents;
	}
	public Date getClaim_date() {
		return Claim_date;
	}
	public void setClaim_date(Date claim_date) {
		Claim_date = claim_date;
	}
	public Stateclaim getStateclaim() {
		return Stateclaim;
	}
	public void setStateclaim(Stateclaim stateclaim) {
		Stateclaim = stateclaim;
	}
	public Claimtype getClaimtype() {
		return claimtype;
	}
	public void setClaimtype(Claimtype claimtype) {
		this.claimtype = claimtype;
	}
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
