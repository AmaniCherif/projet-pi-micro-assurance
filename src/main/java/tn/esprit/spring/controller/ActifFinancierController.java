package tn.esprit.spring.controller;//YosserBenameurController

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication; /////yasmine

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.ActifFinancier;
import tn.esprit.spring.entity.Fond;
import tn.esprit.spring.entity.Rendement;
import tn.esprit.spring.service.Implementation.ActifFinancierService;
import tn.esprit.spring.service.Interface.UserService;





@RestController

public class ActifFinancierController {
	
	@Autowired
	ActifFinancierService actifFinancierService ;
	
	@Autowired
	UserService userService;
	

	
//	@PostMapping("/addactif")
//	@ResponseBody
//	public ResponseEntity<ActifFinancier> ajoutActifFinancierController(@RequestBody ActifFinancier  a ,//Authentication auth	){
//		
//		actifFinancierService.addActifFinancier(a, userService.getcode(auth.getName()).getUser_ID());
//		return new ResponseEntity<ActifFinancier>(HttpStatus.OK);
//	}
	

	
	@GetMapping("/listeActifactuel")  //all  
	@ResponseBody
	public List<ActifFinancier>listemontant_actuelFondEuro(){
		return actifFinancierService.listetouslesfond();
	}
	
	@GetMapping("/listeActifactuelparfond/{fond}")  /*** emp  : all par fond  */
	@ResponseBody
	public List<ActifFinancier>listemontant_actuelFond(@PathVariable("fond") Fond    fond){
		return actifFinancierService.listemontant_actuelFond(fond);
	}
//	@GetMapping("/listeActifactuelparfondUser/{fond}")  /*** user  : all par fond  */
//	@ResponseBody
//	public List<ActifFinancier>listemontant_actuelFondUser(@PathVariable("fond") Fond    fond ,Authentication auth){
//		return actifFinancierService.listemontant_actuelFondparUser(fond,userService.getcode(auth.getName()).getUser_ID());
//	}	
//	
	@GetMapping("/change/{id}")
	@ResponseBody
	public ResponseEntity<ActifFinancier>FondEuro_to_EuroCroissance(@PathVariable("id") Long id){
		actifFinancierService.FondEuro_to_EuroCroissance(id);
		return new ResponseEntity<ActifFinancier>(HttpStatus.OK);		
	}
	
	@GetMapping("/actifactuel/{id}")
	@ResponseBody
	public ResponseEntity<ActifFinancier>montant_actuelFondEuro(@PathVariable("id") Long id){
		actifFinancierService.montant_actuelFondEuro(id);
		return new ResponseEntity<ActifFinancier>(HttpStatus.OK);		
	}
	
	@GetMapping("/actifactuelC/{id}")
	@ResponseBody
	public ResponseEntity<ActifFinancier>montant_actuelEuroCroissance(@PathVariable("id") Long id){
		actifFinancierService.montant_actuelEuroCroissance(id);
		return new ResponseEntity<ActifFinancier>(HttpStatus.OK);		
	}

}
