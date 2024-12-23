package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.entity.State_Sinistre_Claim;

public interface ISinistreService {

	List<Sinistre> retrieveALLSinistre();
	Sinistre addSinistre(Sinistre s);
	void deleteSinistre(Integer id);
	Sinistre updateSinistre(Sinistre s);
	Sinistre retrieveSinistre(Integer id);
	
	String flowSinistre(int idSinistre);
	String TimeLimitVerification(int idSinistre);
	//float TDEMPRUNTEUR(Long idS   ) throws ParseException ;
	//float CreditSimulator( Long idS , Long idC) ;
	
}
