package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class ReinsuranceContract {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "reinContId", unique = true, nullable = false)
	private long reinContId ;
	private String type;
	private double commerPrem ;
	private double purePrem ;
	private double repayment ;
	@OneToOne
	private Contract contract;
	public long getReinContId() {
		return reinContId;
	}
	public void setReinContId(long reinContId) {
		this.reinContId = reinContId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCommerPrem() {
		return commerPrem;
	}
	public void setCommerPrem(double commerPrem) {
		this.commerPrem = commerPrem;
	}
	public double getPurePrem() {
		return purePrem;
	}
	public void setPurePrem(double purePrem) {
		this.purePrem = purePrem;
	}
	public double getRepayment() {
		return repayment;
	}
	public void setRepayment(double repayment) {
		this.repayment = repayment;
	}

	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ReinsuranceContract() {
	}
}
