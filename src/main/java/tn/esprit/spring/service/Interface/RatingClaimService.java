package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Ratingclaim;

public interface RatingClaimService {
	public List<Ratingclaim> RetrieveAllRatingclaim(); 
	Ratingclaim AddRatingclaim(Ratingclaim c);
	void DeleteRatingclaim(String id);
	Ratingclaim UpdateRatingclaim(Ratingclaim c , Long id );
	Ratingclaim RetrieveRatingclaim(String id);

}
