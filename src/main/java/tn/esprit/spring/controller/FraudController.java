package tn.esprit.spring.controller;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.ActifFinancier;
import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.entity.Fraud;
import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.entity.Typesante;
import tn.esprit.spring.repository.SinistreRepository;
import tn.esprit.spring.service.Implementation.FraudService;
import tn.esprit.spring.service.Interface.UserService;
@RestController
 
public class FraudController {
	
	@Autowired
	SinistreRepository sinistre ;
	@Autowired
	FraudService fraudService ;

	
	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {	
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		Map<Float, Float> yminmax = new LinkedHashMap<>();
		float ymin = 0 ;
		float ymax = 0 ;
		int mind = sinistre.mindate().get(0).getDate_Payment().getYear()+1900;
		int maxd = sinistre.maxdate().get(0).getDate_Payment().getYear()+1900;
		for (int i = mind ; i<=maxd ; i++){
		List<Sinistre> l = sinistre.findbyDateReglement(i);
		float somme = 0 ;
		
		for(Sinistre ll : l){
		somme = (float) (somme + ll.getRepayment_capital()) ;
		}	
		System.out.println("sommmmmm" + somme);
		surveyMap.put(String.valueOf(i), (int) somme);	

		if(ymin>=somme ){
			ymin = somme ;
		}
		if(ymax<= somme ){
			ymax = somme ;
		}
		yminmax.put(ymin,ymax);
		} 
		//hashmap l key n7ot fih fil ymin  w value n7ot fih fil ymax w na3di fil hashmap l chart .. genre nzidha b hethi model.addattribute
		
		
		model.addAttribute("yminmax", yminmax);
		model.addAttribute("surveyMap", surveyMap);
		
		return "barGraph";
	}
	
	@GetMapping("/verifFraud/{idUser}")
	@ResponseBody
	public ResponseEntity<Fraud>verifFraud(@PathVariable("idUser") Long id){
		fraudService.verifFraud(id);
		return new ResponseEntity<Fraud>(HttpStatus.OK);		
	}

	//////////////////////////////
	@GetMapping("/verifMontantContratFraud/{idUser}")
	@ResponseBody
	public ResponseEntity<Fraud>verifMontantContratFraud(@PathVariable("idUser") Contract c){
		fraudService.verifMontantContratFraud(c);
		return new ResponseEntity<Fraud>(HttpStatus.OK);	
		//////////////////////////////////////////
		
	}
	////////////////////////////////////////////////////////////////////////////////
//	@GetMapping("/verifNombreContratFraud/{idUser}")
//	@ResponseBody
//	public ResponseEntity<Fraud>verifNombreContratFraud(@PathVariable("idUser") Contract c){
//		fraudService.verifNombreContratFraud(c);
//		return new ResponseEntity<Fraud>(HttpStatus.OK);	
//		//////////////////////////////////////////
//		
		
	
	
	@GetMapping("/verifRachatTotalFraud/{idSinister}")
	@ResponseBody
	public ResponseEntity<Fraud>verifRachatTotalFraud(@PathVariable("idSinister") int s){
		Sinistre se =  sinistre.findById(s).orElse(null);
		fraudService.verifRachatTotalFraud(se);
		return new ResponseEntity<Fraud>(HttpStatus.OK);}
	
	@GetMapping("/verifRachatPartielFraud/{idSinister}")
	@ResponseBody
	public ResponseEntity<Fraud>verifRachatPartielFraud(@PathVariable("idSinister") int s){
		Sinistre se =  sinistre.findById(s).orElse(null);
		fraudService.verifRachatTotalFraud(se);
		return new ResponseEntity<Fraud>(HttpStatus.OK);}
	
}
