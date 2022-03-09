package tn.esprit.spring.service.Implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.repository.OfferRepository;
import tn.esprit.spring.service.Interface.IOfferService;

import org.springframework.stereotype.Service;



@Service
public class OfferServiceImpl implements IOfferService {
	@Autowired 
	OfferRepository offerRepository;

	@Override
	public List<Offer> retrieveAll_Offers() {
		List<Offer> offers =(List<Offer>) offerRepository.findAll();

		return offers;
	}

	@Override
	public Offer add_Offers(Offer O) {
		Offer OfferSaved = null;
		OfferSaved =offerRepository.save(O);
		return OfferSaved;
		
	}

	@Override
	public void delete_Offers(int IdOffer) {

		offerRepository.deleteById(IdOffer);
	}

	@Override
	public Offer update_Offers(Offer O) {
		Offer OffreAdded = offerRepository.save(O);
		return OffreAdded;
		
	}

	@Override
	public Offer retrieve_Offers(int IdOffer) {
		System.out.println("offer id =" + IdOffer);
		Offer O = offerRepository.findById(IdOffer).orElse(null);
		System.out.println("offre returned "+O);
		return O ;
		
	}
	
	
	
	

}
