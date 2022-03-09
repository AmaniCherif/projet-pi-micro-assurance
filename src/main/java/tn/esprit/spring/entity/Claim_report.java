package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;




import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@SuppressWarnings("serial")
@Entity


public class Claim_report implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long idClaims;
	@Temporal(TemporalType.DATE)
	private Date Claim_date;
	private String Claim_description; 
	private Integer Claim_process;
	@Enumerated(EnumType.STRING)
	private Claim_type claim_type;
	


	public Long getIdClaims() {
		return idClaims;
	}

	public void setIdClaims(Long idClaims) {
		this.idClaims = idClaims;
	}

	public Date getClaim_date() {
		return Claim_date;
	}

	public void setClaim_date(Date claim_date) {
		Claim_date = claim_date;
	}

	public String getClaim_description() {
		return Claim_description;
	}

	public void setClaim_description(String claim_description) {
		Claim_description = claim_description;
	}

	public Integer getClaim_process() {
		return Claim_process;
	}






	public void setClaim_process(Integer claim_process) {
		Claim_process = claim_process;
	}






	@ManyToOne
	private User user; 
	


}
