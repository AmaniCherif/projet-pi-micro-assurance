package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Ratingclaim;
import tn.esprit.spring.repository.RatingclaimRepository;
import tn.esprit.spring.service.Interface.RatingclaimService;


public class RatingclaimServiceImpl implements RatingclaimService {
	@Autowired
	RatingclaimRepository Ratingclaimrep;



	@Override
	public List<Ratingclaim> RetrieveAllRatingclaim() {
		// TODO Auto-generated method stub
		
		return Ratingclaimrep.findAll();
	}

	@Override
	public Ratingclaim AddRatingclaim(Ratingclaim c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ratingclaim DeleteRatingclaim(Double id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ratingclaim UpdateRatingclaim(Ratingclaim c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ratingclaim RetrieveRatingclaim(Double id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
