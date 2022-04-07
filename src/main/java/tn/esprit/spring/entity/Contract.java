package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



	@Entity
	@Table(name="Contract")
	public class Contract implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	

	@Temporal (TemporalType.DATE)
	private Date dateDebut;

	@Temporal (TemporalType.DATE)
	private Date dateExpiration;

	private int duration;
	
	private String state;
	
	private String type;
	
	private Float primeCommercial;
	
	private Float primePure;
	
	private int scoring;
	
	private int acceptReq;
	

	private float reassure;
	
	public Long getId() {
		return id;
	}

//	public float getRemboursement() {
//		return remboursement;
//	}
//	public void setRemboursement(float remboursement) {
//		this.remboursement = remboursement;
//	}
//	public int getNumContrat() {
//		return NumContrat;
//	}
//	public void setNumContrat(int numContrat) {
//		NumContrat = numContrat;
//	}


	public void setId(Long id) {
		this.id = id;
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
	
	public float getReassure() {
		return reassure;
	}

	public void setReassure(float reassure) {
		this.reassure = reassure;
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

	public Set<Transaction> getTransaction() {
		return transaction;
	}
	
	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}


	public ContractRequest getContractRequest() {

		return contractRequest;
	}
	public void setContractRequest(ContractRequest contractRequest) {
		this.contractRequest = contractRequest;
	}

	public Set<SinistreReport> getSinistreReport() {
		return sinistreReport;
	}
	public void setSinistreReport(Set<SinistreReport> sinistreReport) {
		this.sinistreReport = sinistreReport;
	}
	public ReinsuranceContract getReinsuranceContract() {
		return reinsuranceContract;
	}
	public void setReinsuranceContract(ReinsuranceContract reinsuranceContract) {
		this.reinsuranceContract = reinsuranceContract;
	}


	@OneToMany(mappedBy="contract")
	private Set<Transaction> transaction;





	@OneToOne(mappedBy="contract")
	private ContractRequest contractRequest;
	
	@OneToMany(mappedBy="contract")
	private Set<SinistreReport> sinistreReport;
	
	@OneToOne(mappedBy="contract")
	private ReinsuranceContract reinsuranceContract;

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@OneToOne
//	private SinistreReport sinistreReport;
	 @ManyToOne
	 private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
