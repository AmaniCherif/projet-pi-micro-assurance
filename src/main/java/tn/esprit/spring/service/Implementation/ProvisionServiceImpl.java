package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Provision;
import tn.esprit.spring.repository.ProvisionsRepository;
import tn.esprit.spring.service.Interface.IProvisionService;

public class ProvisionServiceImpl implements IProvisionService{

	@Autowired
	ProvisionsRepository provisionsRepository;
	
	@Override
	public List<Provision> retrieveALLProvision() {
		List<Provision> provisions =(List<Provision>)provisionsRepository.findAll();
		return provisions;
	}

	@Override
	public Provision addProvision(Provision provision) {
		provisionsRepository.save(provision);
		return provision;
	}

	@Override
	public void deleteProvision(Integer id) {
		provisionsRepository.deleteById(id);
		
	}

	@Override
	public Provision updateProvision(Provision provision) {
		provisionsRepository.save(provision);
		return provision;
	}

	@Override
	public Provision retrieveProvision(Integer id) {
		
		return provisionsRepository.findById(id).get();
	}

}
