package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Ratingclaim implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long idRclaim;
	private int note;
	private String description;
	
	
	public Long getIdRclaim() {
		return idRclaim;
	}
	public void setIdRclaim(Long idRclaim) {
		this.idRclaim = idRclaim;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToOne(mappedBy="ratingclaim")
	private Claims claims ;


	public Claims getClaims() {
		return claims;
	}
	public void setClaims(Claims claims) {
		this.claims = claims;
	}
	public Ratingclaim(int note, String description) {
		super();
		this.note = note;
		this.description = description;
		
	}
	
	
}
