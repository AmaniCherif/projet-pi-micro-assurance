package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;



import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table( name ="Claims")

public class Claims implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClaims")
	private Long idClaims;
	private Long State;
	private String Description; 
	@Temporal(TemporalType.DATE)
	private Date Claim_date;
	private String Claim_type;
	
	

	public long getIdClaims() {
		return idClaims;
	}

	public void setIdClaims(long idClaims) {
		this.idClaims = idClaims;
	}

	public Long getState() {
		return State;
	}

	public void setState(Long state) {
		State = state;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getClaim_type() {
		return Claim_type;
	}

	public void setClaim_type(String claim_type) {
		Claim_type = claim_type;
	}

	public Date getClaim_date() {
		return Claim_date;
	}

	public void setClaim_date(Date claim_date) {
		Claim_date = claim_date;
	}

	
	@ManyToOne
	private User user; 
	

}
