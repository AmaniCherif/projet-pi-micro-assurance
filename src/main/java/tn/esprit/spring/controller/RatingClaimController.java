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

import tn.esprit.spring.entity.Ratingclaim;
import tn.esprit.spring.service.Implementation.RatingclaimServiceImpl;

@RestController
@RequestMapping("/RatingClaim")
public class RatingClaimController {
	@Autowired
	RatingclaimServiceImpl csi;
	
@GetMapping("/getAllRatingClaim")
	public List<Ratingclaim> getAllRatingclaims() {			
	return csi.RetrieveAllRatingclaim();
}

@PostMapping("/addRatingClaim")
	public Ratingclaim AddRatingClaim(@RequestBody Ratingclaim c)
		{csi.AddRatingclaim(c);
		return c;
		}

@DeleteMapping("/deleteById/{ref_claims}")  
public void DeleteRatingclaimById(@PathVariable("ref_claims")String ref_claims) {
	csi.DeleteRatingclaim(ref_claims);}

@PutMapping("/updateClaims")
public Claims UpdateClaims(@RequestBody Claims c) {
	return csi.UpdateClaims(c);
	}
@GetMapping("/retrieve-claims")
public Claims RetrieveClaims(@PathVariable("id") Double id) {
return csi.RetrieveClaims(id);
} 
	
	
	
	
}
