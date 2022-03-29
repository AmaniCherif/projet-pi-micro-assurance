package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.ContractOffer;

public interface ContractOfferService {
	 List<ContractOffer> retrieveAll_Contractoffers();
	 ContractOffer addContract_Offers(ContractOffer cf);
	 void deleteContract_Offers(int id);
	 ContractOffer Contract_OffersByUser(int id);
	 ContractOffer updateContract_Offers(ContractOffer cf);
	 ContractOffer retrieveContract_Offers(int id);
	 public double Tarification_Mixte_PrimePeriodique(double vie_mixte,double dèces_mixte,int duree,int age );
	 public Double Tarification_Mixte_PrimeUnique(double vie_mixte,double dèces_mixte,int duree,int age );
	 ContractOffer AddContractMixte(ContractOffer c , int id);
}
