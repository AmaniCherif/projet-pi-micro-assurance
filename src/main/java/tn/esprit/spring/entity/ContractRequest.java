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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name="ContractRequest")


public class ContractRequest {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column( name = "numRequest")
	private int numRequest; // ClÃ© primaire
	@Temporal(TemporalType.DATE)
	private Date dateRequest;


	private int duration ;  // des question pour distinction du type de contrat
	private String incomeLevel;
	
     @Enumerated(EnumType.STRING)
     private ProfessionSituation professionSituation;
     
	 @Enumerated(EnumType.STRING)
	 private Prime choixPrime ;
	 private float val_prime;

	// question pour la tarification
	private float capitalAssure ;
	private int capitalOuRente ;
	 
	 
	//beneficiaire
	 private String beneficiary;
	 private int traite ;
	private int cinBeneficiary ;
	 private String reaseon;
	 private int alcoholic;
	 private int smoker;
	 private String chronicDiseases;
	 @Enumerated(EnumType.STRING)
	 private CityUser cityUser;

//	 @Enumerated(EnumType.STRING)
//	 private InsuranceType insuranceType;
	 
	 
	 private String nomContract;
	 

	 @Enumerated(EnumType.STRING)
	 private InsuranceType insuranceType;
	 
	 public String getTypeContract() {
		return typeContract;
	}
	public void setTypeContract(String typeContract) {
		this.typeContract = typeContract;
	}

	 private String typeContract;

	 private String insurancebackground;
	 private double height;
	 private double weight;
	 private int healthChekup;
	 private int sport;
	 private int accepted;
	 private int capitalOrAnnuity ;
	 public int getCapitalOrAnnuity() {
		return capitalOrAnnuity;
	}
	public void setCapitalOrAnnuity(int capitalOrAnnuity) {
		this.capitalOrAnnuity = capitalOrAnnuity;
	}
	public int getAccepted() {
		return accepted;
	}
	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
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
	public int getTraite() {
		return traite;
	}
	public void setTraite(int traite) {
		this.traite = traite;
	}
	 @OneToOne
	 private Contract contract;
	 
	 @ManyToOne
	 private User user;

	
	public Prime getChoixPrime() {
		return choixPrime;
	}
	public void setChoixPrime(Prime choixPrime) {
		this.choixPrime = choixPrime;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getVal_prime() {
		return val_prime;
	}
	public void setVal_prime(float val_prime) {
		this.val_prime = val_prime;
	}
	public int getCapitalOuRente() {
		return capitalOuRente;
	}
	public void setCapitalOuRente(int capitalOuRente) {
		this.capitalOuRente = capitalOuRente;
	}
	public float getCapitalAssure() {
		return capitalAssure;
	}
	public void setCapitalAssure(float capitalAssure) {
		this.capitalAssure = capitalAssure;
	}
	

}
