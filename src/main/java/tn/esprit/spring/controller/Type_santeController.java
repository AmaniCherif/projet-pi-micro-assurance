package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.entity.Typesante;
import tn.esprit.spring.service.Implementation.TypesanteService;






@RestController(value = "type_santeController") // Name of the bean in Spring IoC

public class Type_santeController {
	
	
	@Autowired
	TypesanteService type_santeService ;



	
	
	@PostMapping("/addTypesante/{id}")
	@ResponseBody
	public ResponseEntity<ContractRequest> ajoutDemandeContratSanteController(@RequestBody Typesante  t ,@PathVariable("id")  Long id	){
		type_santeService.addType(id, t);              
		return new ResponseEntity<ContractRequest>(HttpStatus.OK);
	}
	///// http://localhost:8082/addTypesante/69
	@GetMapping("/affichetypesante/{id}")
	@ResponseBody
	public Typesante affichetypesanteparDemandeController(@PathVariable("id")  Long id){
		
		return  type_santeService.affichetypesanteparDemande( id);
	}
	
	

}
