package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.service.Interface.ISinistreService;

@RestController
public class SinistreController {

	@Autowired
	ISinistreService sinistreservice;
	@ResponseBody
	public void addSinistre(@RequestBody Sinistre s) {
		sinistreservice.addSinistre(s);
	}
	
}
