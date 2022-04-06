package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Ratingclaim;

public interface RatingClaimService {
	List<Ratingclaim> RetrieveAllRatingclaim(); 
	Ratingclaim AddRatingclaim(Ratingclaim c);
	void DeleteRatingclaim(Long id);
	Ratingclaim UpdateRatingclaim(Ratingclaim c , Long id );
	Ratingclaim RetrieveRatingclaim(Long id);

}
