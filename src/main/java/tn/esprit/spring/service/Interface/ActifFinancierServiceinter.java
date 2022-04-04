package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.ActifFinancier;
import tn.esprit.spring.entity.Fond;

public interface ActifFinancierServiceinter {

	public void addActifFinancier( ActifFinancier actif , int idUser);
	public List<ActifFinancier> listetouslesfond();
	public List<ActifFinancier> listemontant_actuelFond(Fond f);
	public List<ActifFinancier> listemontant_actuelFondparUser(Fond f,int idUser);
	public ActifFinancier montant_actuelFondEuro(Long id);
	public void FondEuro_to_EuroCroissance(Long id);
	public ActifFinancier montant_actuelEuroCroissance(Long id);
	
}
