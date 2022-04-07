
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.entity.ContractOffer;
import tn.esprit.spring.repository.ContractOfferRepository;
import tn.esprit.spring.service.Interface.ContractOfferService;
@RestController
@RequestMapping("/contractOffer")
public class ContractOfferController {
	@Autowired
	ContractOfferService ContractOfferService;
	@Autowired 
	 UserRepository UserRepository;
	@Autowired
   ContractOfferRepository ContractOfferRepository;
	 
	@GetMapping("/AllContractOffers")
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
	 @PostMapping("/AddContractMixte/{userid}")  
	 @ResponseBody
		public String AddContractMixte(@RequestBody ContractOffer c ,@PathVariable("userid")Long idUser)   
		{  		
		 ContractOfferService.AddContractMixte(c,idUser);
		 return("contract Added Successufuly");
		}

	 
	 @GetMapping("/ContratMixte/export/pdf/{id}")
	    public void exportToPDF(HttpServletResponse response,@PathVariable("id") int id) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=MixteContract_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	        ContractOfferService.export(ContractOfferRepository.findById(id).orElse(null),response);
	        		System.out.println("Pdf Generated successufully ");	       
	         
	    }
	 @GetMapping("/ContratMixte/nbtranche/{userid}")
	    public String nbtranche(HttpServletResponse response,@PathVariable("userid")int userid ) throws DocumentException, IOException {
		 ContractOffer d= ContractOfferService.Contract_OffersByUser(userid);
		 String date = d.getDate_fin() ;
		 double prime = d.getTarification(); // get prime mel base
		 int nbr_tranche =  ContractOfferService.nbre_tranches_restantes(date);
		 
		 double montant_restant = prime * nbr_tranche;
	         
		 return ("You have " + nbr_tranche + " x " + prime + " more payments in your contract = " + montant_restant + " Dinars");
	    }
	 @PostMapping("/ContratMixte/resilience/{userid}")
	    public ContractOffer resilience(HttpServletResponse response,@PathVariable("userid")int userid)  {
		 
		 ContractOffer o2 = ContractOfferService.Contract_OffersByUser(userid);
		 o2.setState_offers(State_Offer.Resillier);


}

