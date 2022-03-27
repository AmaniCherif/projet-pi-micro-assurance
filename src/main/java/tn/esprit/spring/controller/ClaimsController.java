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

import tn.esprit.spring.entity.Claims;

import tn.esprit.spring.service.Implementation.ClaimServiceImpl;






@RestController
@RequestMapping("/Claims")
public class ClaimsController {
	@Autowired
	ClaimServiceImpl csi;
	
@GetMapping("/getAllClaims")
	public List<Claims> getAllclaims() {			
	return csi. RetrieveAllClaims();
}

@PostMapping("/addClaims")
	public Claims AddClaims(@RequestBody Claims c)
		{csi.AddClaims(c);
		return c;
		}

@DeleteMapping("/deleteById/{ref_claims}")  
public void deleteContractById(@PathVariable("ref_claims")String ref_claims) {
	csi.DeleteClaims(ref_claims);}

@PutMapping("/updateClaims")
public Claims UpdateClaims(@RequestBody Claims c) {
	return csi.UpdateClaims(c);
	}
@GetMapping("/retrieve-claims")
public Claims RetrieveClaims(@PathVariable("id") Double id) {
return csi.RetrieveClaims(id);
} 
	
	
	
	
}
