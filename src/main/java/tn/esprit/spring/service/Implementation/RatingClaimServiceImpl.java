package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Ratingclaim;

import tn.esprit.spring.repository.RatingclaimRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.RatingClaimService;




@Service
public  class RatingClaimServiceImpl implements RatingClaimService{
	
	@Autowired
	RatingclaimRepository ratingRepo ; 
	@Autowired
	UserRepository userrepo ;
	
     
	/////////////////////////////////////////////////////////////////////////
	/////////////////////Retrieve_All_Claims/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	private static final Logger L= LogManager.getLogger(RatingClaimServiceImpl.class);
	@Override
	public List<Ratingclaim> RetrieveAllRatingclaim() {
		List<Ratingclaim> users =(List<Ratingclaim>) ratingRepo.findAll();
		for (Ratingclaim user : users){
			L.info("user +++ :" + user);}
		return users; 
	}
    ///////////////////////////////////////////////////////////////////////////
	////////////////////Add_Rating_claims/////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	@Override
	public Ratingclaim AddRatingclaim(Ratingclaim cr) {
		
		ratingRepo.save(cr); 
		return cr ;
	}
	////////////////////////////////////////////////////////////////////////
	//////////////////////Delete_Rating_claim//////////////////////////////
	///////////////////////////////////////////////////////////////////////

	@Override
	public void DeleteRatingclaim(String id) {
		
		ratingRepo.deleteById(Long.parseLong(id));; 
		
	}

	@Override
	public Ratingclaim UpdateRatingclaim(Ratingclaim cr, Long id) {
		// TODO Auto-generated method stub
		Ratingclaim ratingClaim = ratingRepo.findById(id).get(); 
		ratingClaim.setDescription(cr.getDescription());
		ratingClaim.setNote(cr.getNote());
		ratingRepo.save(ratingClaim); 
		
		return ratingClaim;
	}

	@Override
	public Ratingclaim RetrieveRatingclaim(String id) {
		L.info("in RetrieveRatingclaim id = " + id);
		Ratingclaim cr = ratingRepo.findById(Long.parseLong(id)).get();
		L.info("Ratingclaim returned = : " + cr);
		return cr;
	}

}

