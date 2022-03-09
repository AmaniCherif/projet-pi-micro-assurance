package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.service.Implementation.OfferServiceImpl;

public class OfferController {
	@Autowired
	OfferServiceImpl osi;
	//URL : http://localhost:8081/SpringMVC/getAllOffers
	@GetMapping("/getAllOffers")
	public List<Offer> getNomsContractJPQL() {			
		return osi.retrieveAll_Offers();
	}
	
	@PostMapping("/addOffers")
	public Offer add_Offers(@RequestBody Offer offers)
		{osi.add_Offers(offers);
		return offers;
		}
	@DeleteMapping("/deleteById/{IdOffer}")  
	public void deleteById(@PathVariable("IdOffers") int IdOffers) {
		osi.delete_Offers(IdOffers);
	}
}
