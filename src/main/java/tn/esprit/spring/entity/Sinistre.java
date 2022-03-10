package tn.esprit.spring.entity;

import java.io.Serializable;
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
public class Sinistre implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column (name= "id_Sinistre")
	private int id_Sinistre_claim;
	@Temporal(TemporalType.DATE)
	private Date date_Payment;
	private double repayment_capital;
	@Enumerated(EnumType.STRING)
	private State_Sinistre_Claim state_Sinistre_Claim;
	
	@OneToOne(mappedBy = "sinistre")
	private SinistreReport sinistreReport;
	@OneToOne
	private Provision provisions;
	
	public int getId_Sinistre_claim() {
		return id_Sinistre_claim;
	}
	public void setId_Sinistre_claim(int id_Sinistre_claim) {
		this.id_Sinistre_claim = id_Sinistre_claim;
	}
	public Date getDate_Payment() {
		return date_Payment;
	}
	public void setDate_Payment(Date date_Payment) {
		this.date_Payment = date_Payment;
	}
	public double getRepayment_capital() {
		return repayment_capital;
	}
	public void setRepayment_capital(double repayment_capital) {
		this.repayment_capital = repayment_capital;
	}
	public State_Sinistre_Claim getState_Sinistre_Claim() {
		return state_Sinistre_Claim;
	}
	public void setState_Sinistre_Claim(State_Sinistre_Claim state_Sinistre_Claim) {
		this.state_Sinistre_Claim = state_Sinistre_Claim;
	}
	public SinistreReport getSinistreReport() {
		return sinistreReport;
	}
	public void setSinistreReport(SinistreReport sinistreReport) {
		this.sinistreReport = sinistreReport;
	}
	public Provision getProvisions() {
		return provisions;
	}
	public void setProvisions(Provision provisions) {
		this.provisions = provisions;
	}
	
}
