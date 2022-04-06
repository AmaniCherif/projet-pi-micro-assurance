package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Offer;



public interface OfferService {
	
	 List<Offer> retrieveAll_Offers();
	 Offer add_Offers(Offer f);
	 void delete_Offers(Long id);
	 Offer update_Offers(Offer O, Long id );
	 Offer retrieve_Offer(Long id);

	 


}
