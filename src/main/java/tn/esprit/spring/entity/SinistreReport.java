
package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;




import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SinistreReport implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)

	private int id_Sinistre_Report;
	@Temporal(TemporalType.DATE)
	private Date date_Occurance;
	@Temporal(TemporalType.DATE)
	private Date date_reclamation;
	private double sinistre_fees;
	private int claim_processing;
	private String sinistre_type;
	private String sinistre_description;
	private String sinistre_place;
	private int partial_buyback;
	private int total_buyback;
	private int death;
	private int illness;
	
	
	
	public int getId_Sinistre_Report() {
		return id_Sinistre_Report;
	}
	public void setId_Sinistre_Report(int id_Sinistre_Report) {
		this.id_Sinistre_Report = id_Sinistre_Report;
	}
	public Date getDate_Occurance() {
		return date_Occurance;
	}
	public void setDate_Occurance(Date date_Occurance) {
		this.date_Occurance = date_Occurance;
	}
	public Date getDate_reclamation() {
		return date_reclamation;
	}
	public void setDate_reclamation(Date date_reclamation) {
		this.date_reclamation = date_reclamation;
	}
	public double getSinistre_fees() {
		return sinistre_fees;
	}
	public void setSinistre_fees(double sinistre_fees) {
		this.sinistre_fees = sinistre_fees;
	}
	public int getClaim_processing() {
		return claim_processing;
	}
	public void setClaim_processing(int claim_processing) {
		this.claim_processing = claim_processing;
	}
	public String getSinistre_type() {
		return sinistre_type;
	}
	public void setSinistre_type(String sinistre_type) {
		this.sinistre_type = sinistre_type;
	}
	public String getSinistre_description() {
		return sinistre_description;
	}
	public void setSinistre_description(String sinistre_description) {
		this.sinistre_description = sinistre_description;
	}
	public String getSinistre_place() {
		return sinistre_place;
	}
	public void setSinistre_place(String sinistre_place) {
		this.sinistre_place = sinistre_place;
	}
	public int getPartial_buyback() {
		return partial_buyback;
	}
	public void setPartial_buyback(int partial_buyback) {
		this.partial_buyback = partial_buyback;
	}
	public int getTotal_buyback() {
		return total_buyback;
	}
	public void setTotal_buyback(int total_buyback) {
		this.total_buyback = total_buyback;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public int getIllness() {
		return illness;
	}
	public void setIllness(int illness) {
		this.illness = illness;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Sinistre getSinistre() {
		return sinistre;
	}
	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}
	@ManyToOne
	private Contract contract;
	@OneToOne
	private Sinistre sinistre;
}
