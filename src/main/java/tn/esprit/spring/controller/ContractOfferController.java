
package tn.esprit.spring.controller;


import org.springframework.web.bind.annotation.RestController;

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
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.entity.ContractOffer;
import tn.esprit.spring.repository.ContractOfferRepository;
import tn.esprit.spring.service.Interface.ContractOfferService;
@RestController
public class ContractOfferController {
	@Autowired
	ContractOfferService ContractOfferService;
	@Autowired 
	 UserRepository UserRepository;
	@Autowired
   ContractOfferRepository ContractOfferRepository;
	 
	@GetMapping("AllContractOffers")
	 @ResponseBody
	 public List<ContractOffer> getUsers() {
	List<ContractOffer> listContractOffers = ContractOfferService.retrieveAll_Contractoffers();
	 return listContractOffers;
	}
	@PutMapping("/updateContractOffer/{idContractOffer}")
	   @ResponseBody
	   public ContractOffer updateoffer (@RequestBody ContractOffer cf){
		   return  ContractOfferService.updateContract_Offers(cf); 
	   }
	@PostMapping("/addContractOffer")
	@ResponseBody
	public  ContractOffer addSalary(@RequestBody ContractOffer cf) { 
		return ContractOfferService.addContract_Offers(cf);
	}
	@DeleteMapping("/removeContractOffer/{idContractOffer}")
	@ResponseBody
	public void removeContractController(@PathVariable("idContractOffer") int id) {
		ContractOfferService.deleteContract_Offers(id);
	}
	 @PostMapping("AddContractMixte/{userid}")  
	 @ResponseBody
		public String AddContractMixte(@RequestBody ContractOffer c ,@PathVariable("userid")int userid)   
		{  		
		 ContractOfferService.AddContractMixte(c,userid);
		 return("contract Added Successufuly");
		}

}

