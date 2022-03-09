package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.service.Implementation.OfferServiceImpl;
import tn.esprit.spring.service.Interface.IOfferService;


public class OfferController {
	@Autowired
	IOfferService offerService;
	// http://localhost:8082/SpringMVC/AllOffers
		 @GetMapping("AllOffers")
		 @ResponseBody
		 public List<Offer> getAllOffers() {
		List<Offer> listOffers = offerService.retrieveAll_Offers();
		 return listOffers;
		}

}
