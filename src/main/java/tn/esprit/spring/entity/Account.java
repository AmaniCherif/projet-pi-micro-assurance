package tn.esprit.spring.entity;

import javax.persistence.OneToOne;

public class Account {

	
	
	
	@OneToOne (mappedBy="account")
	private Contract contract;
	
}
