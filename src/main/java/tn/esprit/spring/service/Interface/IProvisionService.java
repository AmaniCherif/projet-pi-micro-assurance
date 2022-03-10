package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Provision;

public interface IProvisionService {

	List<Provision> retrieveALLProvision();
	Provision addProvision(Provision provision);
	void deleteProvision(Integer id);
	Provision updateProvision(Provision provision);
	Provision retrieveProvision(Integer id);
}
