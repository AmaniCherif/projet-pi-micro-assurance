package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Account;


public interface AccountService {

	List<Account>retrieveALLContracts();
	Account addContract(Account account);
	void deleteContract(int account_id);
	Account updateContract(Account account);
	Account retrieveContract(int account_id);
}
