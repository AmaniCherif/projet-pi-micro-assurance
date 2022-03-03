package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Account implements Serializable {
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column (name= "account_id")
	private int account_id;
	public int getAccount_id() {
		return account_id;
	}



	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}



	private Float balance;
	
	public Float getBalance() {
		return balance;
	}



	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	
	
}
