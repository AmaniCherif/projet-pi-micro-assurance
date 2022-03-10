package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Claims;



public interface ClaimsService {
	List<Claims> RetrieveAllClaims(); 
	Claims AddClaimsEtAffectationUser(Claims c, Long IdUser);
	void DeleteClaims(Double id);
	Claims UpdateClaims(Claims c , Long idClaim );
	Claims RetrieveClaims(Long id);

}
