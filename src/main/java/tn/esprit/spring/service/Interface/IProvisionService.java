package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Provision;

public interface IProvisionService {

	List<Provision> retrieveALLProvision();
	Provision addProvision(Provision provision);
	void deleteProvision(Integer id);
	Provision updateProvision(Provision provision);
	Provision retrieveProvision(Integer id);
	public float PCD(int idSinistrereport, double i);
	public double PCRV(int idSinistrereport, double i);
	public double PCVE(int idSinistrereport, double i);
}
