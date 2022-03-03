package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Claims;



public interface ClaimsService {
	List<Claims> retrieveAllClaims();

	Claims addClaim(Claims c);

	

	void deleteClaim(Long id);

	Claims updateClaim(Claims c);
	Claims retrieveClaim(Long id);


}
