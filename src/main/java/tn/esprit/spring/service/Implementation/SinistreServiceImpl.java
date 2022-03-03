package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.repository.SinistreRepository;
import tn.esprit.spring.service.Interface.ISinistreService;

public class SinistreServiceImpl implements ISinistreService{

	@Autowired
	SinistreRepository sinistrerepos;
	
	@Override
	public List<Sinistre> retrieveALLSinistre() {
		List<Sinistre> sinistres =(List<Sinistre>)sinistrerepos.findAll();
		return sinistres;
	}

	@Override
	public Sinistre addSinistre(Sinistre s) {
		sinistrerepos.save(s);
		return s;
	}

	@Override
	public void deleteSinistre(Long id) {
		sinistrerepos.deleteById(id);
		
	}

	@Override
	public Sinistre updateSinistre(Sinistre s) {
		sinistrerepos.save(s);
		return s;
	}

	@Override
	public Sinistre retrieveSinistre(Long id) {
		
		return sinistrerepos.findById(id).get();
	}

}
