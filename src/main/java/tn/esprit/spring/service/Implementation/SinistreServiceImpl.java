package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.entity.State_Sinistre_Claim;
import tn.esprit.spring.repository.SinistreRepository;
import tn.esprit.spring.service.Interface.ISinistreService;


@Service
public class SinistreServiceImpl implements ISinistreService{

	@Autowired
	SinistreRepository sinistrerepos;

	@Override
	public List<Sinistre> retrieveALLSinistre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sinistre addSinistre(Sinistre s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSinistre(Integer id) {
		sinistrerepos.deleteById(id);
		
	}

	@Override
	public Sinistre updateSinistre(Sinistre s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sinistre retrieveSinistre(Integer id) {
		
		return sinistrerepos.findById(id).get();
	}
	

	@Override
	public List<Sinistre> findByState(State_Sinistre_Claim state_Sinistre_Claim) {
		
		return sinistrerepos.findSinistreByState(state_Sinistre_Claim);
	}

}