package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.DataFondEURO;
import tn.esprit.spring.entity.Rendement;
//import tn.esprit.spring.entity.Simulateur;
import tn.esprit.spring.service.Implementation.DataFondEuroService;




@RestController
public class DataFondEUROController {
	
	@Autowired
	DataFondEuroService dataFondEuroService ;
	

	@GetMapping("/listePortefeuilleBTA")
	@ResponseBody
	public List<DataFondEURO>listeBTA(){
			return dataFondEuroService.listeBTA();
	}
	@GetMapping("/listePortefeuille")
	@ResponseBody
	public List<DataFondEURO>listeAll(){
		return 	dataFondEuroService.listeAll();
		
	}
	@GetMapping("/listeRendementPortefeuille")
	@ResponseBody
	public List<Rendement>listeRendementPortefeuille(){
		return 	dataFondEuroService.listeRendementPortefeuille();
		
	}
	

	
	@PostMapping("/addPorteufeuille")
	@ResponseBody
	public ResponseEntity<DataFondEURO> ajoutBondController(@RequestBody DataFondEURO  a 	){
		
		dataFondEuroService.addDataEuro(a);
		return new ResponseEntity<DataFondEURO>(HttpStatus.OK);
	}
	@GetMapping("/DeletePorteufeuille/{id}")
	@ResponseBody
	public ResponseEntity<DataFondEURO> DeleteBondController( @PathVariable("id") int    id	){
		
		dataFondEuroService.deleteFondEURO(id);
		return new ResponseEntity<DataFondEURO>(HttpStatus.OK);
	}
	
	
	
	@GetMapping("/rendement2")
	@ResponseBody
	public ResponseEntity<DataFondEURO>calculeRendementBTA2(){
		dataFondEuroService.calculerendementTotal();
		return new ResponseEntity<DataFondEURO>(HttpStatus.OK);
			
	}
	
	@GetMapping("/l")
	@ResponseBody
	public ResponseEntity<DataFondEURO>l(){
		dataFondEuroService.liste();
		return new ResponseEntity<DataFondEURO>(HttpStatus.OK);
			
	}
	

	@GetMapping("/calculeprofitUnique")
	@ResponseBody
	public ResponseEntity<DataFondEURO>calculeprofitUnique(){
		dataFondEuroService.calculeprofitUnique();
		return new ResponseEntity<DataFondEURO>(HttpStatus.OK);
			
	}
	@GetMapping("/calculeprofitPeriodique")
	@ResponseBody
	public ResponseEntity<DataFondEURO>calculeprofitPeriodique(){
		dataFondEuroService.calculeprofitPeriodique();
		return new ResponseEntity<DataFondEURO>(HttpStatus.OK);
			
	}

	
	/*@GetMapping("/date2")
	@ResponseBody
	public ResponseEntity<DataFondEURO>montant_actuelProfitUnique(){
		dataFondEURO.montant_actuelProfitUnique();
		return new ResponseEntity<DataFondEURO>(HttpStatus.OK);			
	}*/
	

}
