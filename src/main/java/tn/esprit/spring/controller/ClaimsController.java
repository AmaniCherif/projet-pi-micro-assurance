package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Claims;
//import tn.esprit.spring.service.Implementation.ClaimsServiceImpl;
import tn.esprit.spring.service.Interface.ClaimsService;

@RestController
public class ClaimsController {

	@Autowired
	ClaimsService ClaimService ;
	
	@GetMapping("/getAllClaims")
	@ResponseBody
	public List<Claims> getAllclaims() {			
	return ClaimService.retrieveAllClaims(); 
}
	
	@PostMapping("/addClaims/{user_id}" )
	@ResponseBody	
	public Claims AddClaims(@RequestBody Claims c,@PathVariable("user_id")Long UserID )
		{ClaimService.addClaim(c,UserID); 
		return c;
		}
	
	@DeleteMapping("/deleteClaimById/{ClaimID}")  
	public void deleteClaimById(@PathVariable("ClaimID")Long ClaimID) {
	ClaimService.deleteClaim(ClaimID) ; 
	
	}
	
	@PutMapping("/updateClaims/{ClaimID}")
	@ResponseBody
	public Claims UpdateClaims(@RequestBody Claims c,@PathVariable("ClaimID")Long ClaimID) {
		return ClaimService.updateClaim(c, ClaimID); 
		}
	
	 @GetMapping("/retrieveClaim/{ClaimID}")
	    public Claims retrieveClaim(@PathVariable("ClaimID") Long ClaimID) {
	        return ClaimService.retrieveClaim(ClaimID); 
	    }
	
	
	
}
