package tn.esprit.spring.service.Interface;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Accounting;

public interface AccountingService {
	public List<Accounting> retrieveAllAccountings();
	public Accounting addAccounting(Accounting s) ;
	public void deleteAccounting(String id) ;
	public Accounting updateAccounting(Accounting s);
	public Accounting retrieveAccounting(String id);
	void affecterAccountingToUser(int idp, int id);
	public float assets();
	public float liabilities();
	public int exercise_result();
	public float totalPrimeCom();
	public float totalFrais();
	public float ReinsuranceComm();
	public String Resultat();
	public float prevision(Date d);
}
