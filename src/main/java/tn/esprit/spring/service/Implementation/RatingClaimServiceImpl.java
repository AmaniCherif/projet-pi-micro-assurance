package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Ratingclaim;

import tn.esprit.spring.repository.RatingclaimRepository;
import tn.esprit.spring.service.Interface.RatingClaimService;


@Service
public class RatingClaimServiceImpl implements RatingClaimService{
	
	@Autowired
	RatingclaimRepository ratingRepo ; 
	
 ///hello_word//
	@Override
	public List<Ratingclaim> RetrieveAllRatingclaim() {
		// TODO Auto-generated method stub
		return (List<Ratingclaim>) ratingRepo.findAll();
	}

	@Override
	public Ratingclaim AddRatingclaim(Ratingclaim c) {
		// TODO Auto-generated method stub
		ratingRepo.save(c); 
		return c ;
	}

	@Override
	public void DeleteRatingclaim(Long id) {
		// TODO Auto-generated method stub
		Ratingclaim ratingClaim = ratingRepo.findById(id).get(); 
		
	}

	@Override
	public Ratingclaim UpdateRatingclaim(Ratingclaim c, Long id) {
		// TODO Auto-generated method stub
		Ratingclaim ratingClaim = ratingRepo.findById(id).get(); 
		ratingClaim.setDescription(c.getDescription());
		ratingClaim.setNote(c.getNote());
		ratingRepo.save(ratingClaim); 
		
		return ratingClaim;
	}

	@Override
	public Ratingclaim RetrieveRatingclaim(Long id) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(id).get();
	}

}

