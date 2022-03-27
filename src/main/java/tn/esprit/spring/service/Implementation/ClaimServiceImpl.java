package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Claims;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ClaimsRepository;

import tn.esprit.spring.service.Interface.ClaimsService;


@Service
public class ClaimServiceImpl implements ClaimsService{
	@Autowired
	ClaimsRepository claimRep;

	@Override
	public List<Claims> RetrieveAllClaims() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Claims AddClaimsEtAffectationUser(Claims c, Long IdUser) {
		// TODO Auto-generated method stub
		User userRating = 
			
		return null;
	}

	@Override
	public void DeleteClaims(Double id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Claims UpdateClaims(Claims c, Long idClaim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claims RetrieveClaims(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
