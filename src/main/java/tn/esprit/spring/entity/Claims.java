package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity


public class Claims implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Double Claim_id;
	@Temporal(TemporalType.DATE)
	private Date Claimdate;
	@Enumerated(EnumType.STRING)
	private State_claim state_claim;
	public Double getClaim_id() {
		return Claim_id;
	}
	public void setClaim_id(Double claim_id) {
		Claim_id = claim_id;
	}
	public Date getClaim_date() {
		return Claimdate;
	}
	public void setClaim_date(Date claimdate) {
		Claimdate = claimdate;
	}
	
}
	