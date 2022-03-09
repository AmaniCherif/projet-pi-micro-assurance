package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Account;
import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.repository.AccountRepository;
import tn.esprit.spring.service.Interface.AccountService;

public class AccountServiceImpl  implements AccountService{
	@Autowired
	AccountRepository accountRep;

	

	@Override
	public Account addContract(Account account) {
		accountRep.save(account);
		return account;	
	}

	@Override
	public void deleteContract(int account_id) {
		accountRep.deleteById(account_id);		
	}

	@Override
	public Account updateContract(Account account) {
		Account acountadd = accountRep.save(account);
		return acountadd;
	}

	@Override
	public Account retrieveContract(int account_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Account> retrieveALLContracts() {
		// TODO Auto-generated method stub
		return null;
	}

	}


