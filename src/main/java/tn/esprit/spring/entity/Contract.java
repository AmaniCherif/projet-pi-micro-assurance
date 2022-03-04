package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Contract")
public class Contract implements Serializable {

	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue
	private String ref_contrat;
	@Temporal (TemporalType.DATE)
	private Date dateDebut;
	@Temporal (TemporalType.DATE)
	private Date dateExpiration;
	private int duration;
	private int state;
	private String type;
	private Float primeCommercial;
	
	
	public String getRef_contrat() {
		return ref_contrat;
	}
	public void setRef_contrat(String ref_contrat) {
		this.ref_contrat = ref_contrat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getPrimeCommercial() {
		return primeCommercial;
	}
	public void setPrimeCommercial(Float primeCommercial) {
		this.primeCommercial = primeCommercial;
	}
	
	
	
	
	
	
	
}
