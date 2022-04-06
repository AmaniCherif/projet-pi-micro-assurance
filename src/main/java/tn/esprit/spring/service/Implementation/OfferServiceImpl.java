package tn.esprit.spring.service.Implementation;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.repository.OfferRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.OfferService;

import org.springframework.stereotype.Service;



@Service
public class OfferServiceImpl implements OfferService {
	@Autowired 
	OfferRepository offerRepository;
	@Autowired 
	UserRepository userRepository;
	
	
	@Override
	public List<Offer> retrieveAll_Offers() {
		

		return (List<Offer>) offerRepository.findAll();
	}

	@Override
	public Offer add_Offers(Offer O) {
		offerRepository.save(O);
		return O;
		
	}

	@Override
	public void delete_Offers(Long IdOffer) {

		offerRepository.deleteById(IdOffer);
	}

	@Override
	public Offer update_Offers(Offer o, Long id ) {
		Offer offreModif = offerRepository.findById(id).get(); 
		 
		offreModif.setDescription(o.getDescription());
	 
		
		
		offerRepository.save(offreModif);
		return offreModif;
		
	}

	@Override
	public Offer retrieve_Offer(Long IdOffer) {
		Offer O = offerRepository.findById(IdOffer).get();
		return O ;
		
	}
	
	
}
