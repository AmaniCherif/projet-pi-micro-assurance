package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity

public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	
	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	private float transactionAmount;
	@Enumerated(EnumType.STRING)
	TypeTransaction typeTransaction ;
 

	
	//@JoinColumn(name = "id",referencedColumnName="id")
	//@JsonIgnore
	@JsonBackReference
	@ManyToOne
	private Contract contract;
	
    
	
	public int getTransactionid() {
		return transactionid;
	}



	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}



	public Date getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	public float getTransactionAmount() {
		return transactionAmount;
	}



	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}



	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}



	public void setTypeTransaction(TypeTransaction typeTransaction) {
		this.typeTransaction = typeTransaction;
	}
	

	

//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}



	

	
	

	


	public Transaction() {
		super();
	}



	public Contract getContract() {
		return contract;
	}



	public void setContract(Contract contract) {
		this.contract = contract;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	
    


	
}

