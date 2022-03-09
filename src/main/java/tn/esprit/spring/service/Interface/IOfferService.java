package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Offer;



public interface IOfferService {
	 List<Offer> retrieveAll_Offers();
	 Offer add_Offers(Offer f);
	 void delete_Offers(int id);
	 Offer update_Offers(Offer f);
	 Offer retrieve_Offers(int id);
	 


}
