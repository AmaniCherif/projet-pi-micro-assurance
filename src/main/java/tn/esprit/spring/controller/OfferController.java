package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import tn.esprit.spring.entity.Offers;
import tn.esprit.spring.service.Implementation.OffersServiceImpl;

public class OfferController {
	@Autowired
	OffersServiceImpl osi;
	@GetMapping("/getAllOffers")
	public List<Offers> getNomsContractJPQL() {			
		return osi.retrieveAll_Offers();
	}
	
	@PostMapping("/addOffers")
	public Offers add_Offers(@RequestBody Offers offers)
		{osi.add_Offers(offers);
		return offers;
		}
	@DeleteMapping("/deleteById/{IdOffer}")  
	public void deleteById(@PathVariable("IdOffers") int IdOffers) {
		osi.delete_Offers(IdOffers);
	}
}
