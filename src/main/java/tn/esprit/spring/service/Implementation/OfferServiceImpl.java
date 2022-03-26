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
	public void delete_Offers(int IdOffer) {

		offerRepository.deleteById(IdOffer);
	}

	@Override
	public Offer update_Offers(Offer o, int id ) {
		Offer offreModif = offerRepository.findById(id).get(); 
		offreModif.setDate_debut(o.getDate_debut());
		offreModif.setDate_fin(o.getDate_fin());
		offreModif.setDescription(o.getDescription());
		offreModif.setState_offers(o.getState_offers());
		offreModif.setTarification(o.getTarification());
		
		
		offerRepository.save(offreModif);
		return offreModif;
		
	}

	@Override
	public Offer retrieve_Offer(int IdOffer) {
		Offer O = offerRepository.findById(IdOffer).get();
		return O ;
		
	}
	
	
}
