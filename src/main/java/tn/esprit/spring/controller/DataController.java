package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Data;
import tn.esprit.spring.service.Implementation.DataServiceImpl;

@RestController

public class DataController {
	
	
	@Autowired
	DataServiceImpl dataService;
////////////////prime unique : capital differé ////////////
	@GetMapping("/Capital_vieC/{c}/{age}/{an}/{inte}/{sexe}")
	@ResponseBody
	public ResponseEntity<Data> dataCapitalControllerCapital(@PathVariable("c") float c,
	@PathVariable("age") int age,
	@PathVariable("an") int an,
	@PathVariable("inte") double inte,
	@PathVariable("sexe") String sexe){
		
	dataService.calculePUCapital_vieCapital(c, age, an, inte,sexe);
	return new ResponseEntity<Data>(HttpStatus.OK);
	}
	}
