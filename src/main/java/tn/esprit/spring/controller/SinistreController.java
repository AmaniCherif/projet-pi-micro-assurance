package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.service.Implementation.SinistreServiceImpl;

@RestController
@RequestMapping("/Sinistre")
public class SinistreController {

	@Autowired
	SinistreServiceImpl ssi;
	
	@PostMapping("/addSinistre")
	public Sinistre addSinistre(@RequestBody Sinistre  s) {
		ssi.addSinistre(s);
		return s;
	}
	@GetMapping("/getallSinistre")
	public List<Sinistre> getallSinistre(){
		return ssi.retrieveALLSinistre();
	}
	
	@DeleteMapping("/deleteSinistre/{idSin}")
	public void DeleteSinistre(@PathVariable ("idSin") int idSin) {
		ssi.deleteSinistre(idSin);
	}
	
	@PutMapping("/updateSinistre/{idSin}")
	public Sinistre updateSinistre(@RequestBody  Sinistre s, @PathVariable ("idSin") int idSin) {
		return ssi.updateSinistre(s);
	}
	
	@GetMapping("/getSinistrebyid/{idSin}")
	public Sinistre getSinistrebyid(@PathVariable("idSin") int idSin) {
		return ssi.retrieveSinistre(idSin);
	}
	
	@GetMapping("/flowSinistre/{idSini}")
	public String flowSinistre(@PathVariable("idSin") int idSin) {
		return ssi.flowSinistre(idSin);
	}
	
	@GetMapping("/timelimitverification/{idSin}")
	public String TimeLimitVerification(@PathVariable("idSin") int idSin) {
		return ssi.TimeLimitVerification(idSin)
;	}
	/*@GetMapping("/calculTDE/{idS}")
		@ResponseBody
		  public float TDEMPRUNTEUR(@PathVariable("idS") Long idS) throws ParseException{
		float k = 0 ;
		k = (float) sr.TDEMPRUNTEUR(idS) ; 
		return k ;
	  
	}*/

	/* @GetMapping("/creditsimul/{idS}/{idC}")
		  @ResponseBody
		  public float creditsimul(@PathVariable("idS") Long idS, @PathVariable("idC") Long idC){
				float k = 0 ;
				k = (float) sr.CreditSimulator( idS, idC) ; 
				return k ;
			  
			}*/
}
