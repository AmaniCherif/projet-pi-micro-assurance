package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Claims;
import tn.esprit.spring.entity.Ratingclaim;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ClaimsRepository;
import tn.esprit.spring.repository.RatingclaimRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.ClaimsService;

@Service
public class ClaimsServiceImpl implements ClaimsService{
	@Autowired
    ClaimsRepository claimRep;
	
	@Autowired
	UserRepository userRepo ; 

	@Autowired
	RatingclaimRepository ratingClaimRepository;

	@Override
	public List<Claims> retrieveAllClaims() {
		
		return (List<Claims>) claimRep.findAll();
	}

	@Override
	public Claims addClaim(Claims c , long userId) {
		
	//	User user=userRepo.findById(userId).get();
	//	c.setUser(user);
		claimRep.save(c);
		return c;
	}

	@Override
	public void deleteClaim(Long id) {
		
		Claims claim = claimRep.findById(id).get(); 
		claimRep.delete(claim);
		
		
	}

	@Override
	public Claims updateClaim(Claims c, Long IdClaim) {
		// TODO Auto-generated method stub
		Claims claim = claimRep.findById(IdClaim).get(); 
		claim.setClaim_date(c.getClaim_date());
		claim.setClaim_Descrip(c.getClaim_Descrip());
		claim.setDocuments(c.getDocuments());
		claimRep.save(claim); 
		return claim;
	}

	@Override
	public Claims retrieveClaim(Long id) {
	
		return claimRep.findById(id).get();
	}



}
