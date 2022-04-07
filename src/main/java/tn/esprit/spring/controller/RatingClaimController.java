package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Ratingclaim;

import tn.esprit.spring.service.Interface.RatingClaimService;


@RestController
public class RatingClaimController {
	@Autowired
	RatingClaimService ratingService ; 
	
	//yosser//
	
	@GetMapping("/GetAllRating")
	@ResponseBody
	public List<Ratingclaim> GetAllRating() {
	 
	 return ratingService.RetrieveAllRatingclaim(); 
	 }
	
	@PutMapping("/updateRating/{RatingId}")
	   @ResponseBody
	   public Ratingclaim updateRating(@RequestBody Ratingclaim Rating , @PathVariable("RatingId") Long RatingId){
		   return  ratingService.UpdateRatingclaim(Rating, RatingId); 
		   
	   }
	
	
	 @PostMapping("/addRating")
		@ResponseBody	
		public Ratingclaim addRating(@RequestBody Ratingclaim rating) {
		return ratingService.AddRatingclaim(rating); 
		}
	 
	 @DeleteMapping("/removeRating/{RatingId}")
	    public void removeRating(@PathVariable("RatingId") String RatingId){
		 ratingService.DeleteRatingclaim(RatingId); 
	        
	    }
	 
	 @GetMapping("/retrieveRating/{RatingId}")
	    public Ratingclaim retrieveRating(@PathVariable("RatingId") String RatingId) {
	        return ratingService.RetrieveRatingclaim(RatingId); 
	    }
	
	
}
