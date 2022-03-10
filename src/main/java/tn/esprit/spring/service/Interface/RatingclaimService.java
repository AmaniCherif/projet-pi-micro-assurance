package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Ratingclaim;



public interface RatingclaimService {
	List<Ratingclaim> RetrieveAllRatingclaim(); 
	Ratingclaim AddRatingclaim(Ratingclaim c);
	Ratingclaim DeleteRatingclaim(Double id);
	Ratingclaim UpdateRatingclaim(Ratingclaim c);
	Ratingclaim RetrieveRatingclaim(Double id);

}
