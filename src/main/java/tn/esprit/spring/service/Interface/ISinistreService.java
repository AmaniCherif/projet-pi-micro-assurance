package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Sinistre;

public interface ISinistreService {

	List<Sinistre> retrieveALLSinistre();
	Sinistre addSinistre(Sinistre s);
	void deleteSinistre(Integer id);
	Sinistre updateSinistre(Sinistre s);
	Sinistre retrieveSinistre(Integer id);
}
