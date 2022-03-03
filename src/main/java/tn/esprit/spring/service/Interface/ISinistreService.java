package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Sinistre;

public interface ISinistreService {

	List<Sinistre> retrieveALLSinistre();
	Sinistre addSinistre(Sinistre s);
	void deleteSinistre(Long id);
	Sinistre updateSinistre(Sinistre s);
	Sinistre retrieveSinistre(Long id);
}
