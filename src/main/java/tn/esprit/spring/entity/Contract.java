package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Contract")
public class Contract implements Serializable {

	private static final long serialVersionUID= 1L;
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String ref_contract;
	@Temporal (TemporalType.DATE)
	private Date dateDebut;
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Temporal(TemporalType.DATE)
	private Date dateFin ;
	private Date dateExpiration;
	private int duration;
	private String state;
	private String type;
	private Float primeCommercial;
	private Float primePure;
	private int scoring;
	private int acceptReq;
	private int reassure;
	private int NumContrat;
	private float remboursement;
	
	public float getRemboursement() {
		return remboursement;
	}
	public void setRemboursement(float remboursement) {
		this.remboursement = remboursement;
	}
	public int getNumContrat() {
		return NumContrat;
	}
	public void setNumContrat(int numContrat) {
		NumContrat = numContrat;
	}
	public int getScoring() {
		return scoring;
	}
	public void setScoring(int scoring) {
		this.scoring = scoring;
	}
	public int getAcceptReq() {
		return acceptReq;
	}
	public void setAcceptReq(int acceptReq) {
		this.acceptReq = acceptReq;
	}
	public int getReassure() {
		return reassure;
	}
	public void setReassure(int reassure) {
		this.reassure = reassure;
	}
	public String getRef_contract() {
		return ref_contract;
	}
	public void setRef_contract(String ref_contract) {
		this.ref_contract = ref_contract;
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

	public String getState() {
		return state;
	}
	public void setState(String state) {
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
	public Float getPrimePure() {
		return primePure;
	}
	public void setPrimePure(Float primePure) {
		this.primePure = primePure;
	}
	
	@OneToMany(mappedBy="contract")
	private Set<Transaction> transaction;
	
	
	@OneToOne(mappedBy="contract")
	private ContractRequest contractRequest;
	
	@OneToMany(mappedBy="contract")
	private Set<SinistreReport> sinistreReport;
	
	@OneToOne
	private ReinsuranceContract reinsuranceContract;
//	@OneToOne
//	private SinistreReport sinistreReport;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	 private User user;

}
