package tn.esprit.spring.controller;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import tn.esprit.spring.entity.Sinistre;
//import tn.esprit.spring.service.Interface.ISinistreService;

@RestController
public class SinistreController {

	/*@Autowired
	ISinistreService sinistreservice;
	@ResponseBody
	public void addSinistre(@RequestBody Sinistre s) {
		sinistreservice.addSinistre(s);
	}
	*/
	
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
