package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Claims;

public interface ClaimsService {
	List<Claims> retrieveAllClaims();
	Claims addClaim(Claims c , long userId);
	void deleteClaim(Long id);
	Claims updateClaim(Claims c , Long IdClaim);
	Claims retrieveClaim(Long id);
}
