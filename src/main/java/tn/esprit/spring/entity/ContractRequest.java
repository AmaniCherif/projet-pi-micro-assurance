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
public class ContractRequest {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	 @Column( name = "idContract")
	private int numRequest; // ClÃ© primaire
	@Temporal(TemporalType.DATE)
	private Date dateRequest;
	
	
	
	// Assurance_Credit , Assurance_Epargne , Assurance_Sante , Assurance_Capital_differe
	//  assurance : cas vie : capital diffÃ©re , rente viagÃ©re
	//              cas dÃ©ces : vie entiÃ©re
	//  santÃ© 

	private String duration ;  // des question pour distinction du type de contrat
	private String incomeLevel;
	
     @Enumerated(EnumType.STRING)
     private ProfessionSituation professionSituation;
     
	 @Enumerated(EnumType.STRING)
	 private Prime choixPrime ;
	

	 //beneficiaire
	 private String beneficiary;

	 private int cinBeneficiary ;
	 private String reaseon;
	 private int alcoholic;
	 private int smoker;
	 private String chronicDiseases;
	 @Enumerated(EnumType.STRING)
	 private CityUser cityUser;
	 @Enumerated(EnumType.STRING)
	 private InsuranceType insuranceType;
	 private String nomContract;
	 private String insurancebackground;
	 private double height;
	 private double weight;
	 private int healthChekup;
	 private int sport;
	 @Enumerated(EnumType.STRING)
	 private ContractType contractType;
	public int getNumRequest() {
		return numRequest;
	}
	public void setNumRequest(int numRequest) {
		this.numRequest = numRequest;
	}
	public Date getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getIncomeLevel() {
		return incomeLevel;
	}
	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}
	public String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}
	public int getCinBeneficiary() {
		return cinBeneficiary;
	}
	public void setCinBeneficiary(int cinBeneficiary) {
		this.cinBeneficiary = cinBeneficiary;
	}
	public String getReaseon() {
		return reaseon;
	}
	public void setReaseon(String reaseon) {
		this.reaseon = reaseon;
	}
	public int getAlcoholic() {
		return alcoholic;
	}
	public void setAlcoholic(int alcoholic) {
		this.alcoholic = alcoholic;
	}
	public int getSmoker() {
		return smoker;
	}
	public void setSmoker(int smoker) {
		this.smoker = smoker;
	}
	public String getChronicDiseases() {
		return chronicDiseases;
	}
	public void setChronicDiseases(String chronicDiseases) {
		this.chronicDiseases = chronicDiseases;
	}
	public String getNomContract() {
		return nomContract;
	}
	public void setNomContract(String nomContract) {
		this.nomContract = nomContract;
	}
	public String getInsurancebackground() {
		return insurancebackground;
	}
	public void setInsurancebackground(String insurancebackground) {
		this.insurancebackground = insurancebackground;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getHealthChekup() {
		return healthChekup;
	}
	public void setHealthChekup(int healthChekup) {
		this.healthChekup = healthChekup;
	}
	public int getSport() {
		return sport;
	}
	public void setSport(int sport) {
		this.sport = sport;
	}
	public ContractType getContractType() {
		return contractType;
	}
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
	 @OneToOne
	 private Contract contracts;
	 
	 @ManyToOne
		private User user;
}
