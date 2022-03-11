/*package tn.esprit.spring.controller;

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
import tn.esprit.spring.repository.SinistreRepository;
import tn.esprit.spring.service.Interface.ISinistreService;

@RestController
@RequestMapping("/Sinistre")
public class SinistreController {

	@Autowired
	ISinistreService sinser;
	@Autowired
	SinistreRepository sinistreRepository;
	
	@PostMapping("/addSinistre")
	public Sinistre addSinistre(@RequestBody Sinistre s) {
		sinser.addSinistre(s);
		return s;
	}
	
	@GetMapping("/getAllSinistre")
	public List<Sinistre> getAllSinistreJPQL(){
		return sinser.retrieveALLSinistre();
	}
	
	@DeleteMapping("deleteByid/{idSinistre}")
	public void deleteSinistreById(@PathVariable("idSinistre")int idSinistre) {
		sinser.deleteSinistre(idSinistre);
	}
	
	@PutMapping("/updateSinistre")
	public Sinistre updateSinistre(@RequestBody Sinistre sinistre) {
		return sinser.updateSinistre(sinistre);
	}
	
	@GetMapping("/retrieveSinistre/{idSinistre}")
	public Sinistre retrieveSinistre(@PathVariable("idSinistre")int idSinistre) {
		return sinser.retrieveSinistre(idSinistre);
	}
}
*/