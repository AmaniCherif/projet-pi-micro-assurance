package tn.esprit.spring.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;


import tn.esprit.spring.entity.ReinsuranceContract;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.Interface.ReinsuranceContractService;



@RestController
public class ReinsuranceContractController {
@Autowired
	ReinsuranceContractService reinSer ;


@GetMapping("/retrieveALLContracts/{id_user}")
@ResponseBody
public ReinsuranceContract retrieveRein(@PathVariable("id_user") Long Id) {
return reinSer.retrieveReinsuranceContract(Id);
}
@PutMapping("/modify-rein")
@ResponseBody
public ReinsuranceContract modifyRein(@RequestBody ReinsuranceContract reinCont) {
return reinSer.updateReinsuranceContract(reinCont);
}
@PostMapping("/add-Rein")	
@ResponseBody	
public ReinsuranceContract addRein(@RequestBody ReinsuranceContract reinCont) {
return  reinSer.addReinsuranceContract(reinCont);
}
@DeleteMapping("/removeReinCont/{reinId}")
public void removeoffer(@PathVariable("reinId") Long id){
	reinSer.deleteReinsuranceContract(id); 
}
}
