package tn.esprit.spring.service.Interface;

import java.util.List;
import tn.esprit.spring.entity.ContractOffer;

public interface ContractOfferService {
	List<ContractOffer>retrieveALLContracts();
	ContractOffer addContract(ContractOffer contOff);
	void deleteContract(String ref_contratOff);
	ContractOffer updateContract(ContractOffer contOff);
	ContractOffer retrieveContract(String ref_contratOff);
}
