package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.service.Interface.OfferService;

@RestController
public class OfferController {
	@Autowired
	OfferService offerService;
	
	
	// http://localhost:8083/SpringMVC/AllOffers
	@GetMapping("/AllOffers")
	@ResponseBody
	public List<Offer> getOffer() {
	 
	 return offerService.retrieveAll_Offers();
	 }
	
	
	@PutMapping("/updateoffer/{offerId}")
	   @ResponseBody
	   public Offer updateoffer(@RequestBody Offer o, @PathVariable("offerId") int offerId){
		   return  offerService.update_Offers(o, offerId); 
		   
	   }
	
		 @PostMapping("/addOffer")
			@ResponseBody	
			public Offer addOffer(@RequestBody Offer o) {
			return offerService.add_Offers(o);
			}
		 
		  @DeleteMapping("/removeoffer/{offerId}")
		    public void removeoffer(@PathVariable("offerId") int offerId){
		        offerService.delete_Offers(offerId); 
		    }
	
		  
		  @GetMapping("/retrieveOffer/{offerId}")
		    public Offer retrieveOffer(@PathVariable("offerId") int offerId) {
		        return offerService.retrieve_Offer(offerId); 
		    }
			
}
