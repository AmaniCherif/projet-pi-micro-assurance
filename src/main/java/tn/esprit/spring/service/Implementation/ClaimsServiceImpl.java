package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Claims;
import tn.esprit.spring.repository.ClaimsRepository;
import tn.esprit.spring.service.Interface.ClaimsService;



@Service
public class ClaimsServiceImpl implements ClaimsService{
	@Autowired
    ClaimsRepository claimRep;

	@Override
	public List<Claims> retrieveAllClaims() {
		@SuppressWarnings("unused")
		List<Claims> claim=(List<Claims>)(claimRep.findAll());
		return null;
	}

	@Override
	public Claims addClaim(Claims c) {
		claimRep.save(c);
		return null;
	}

	@Override
	public void deleteClaim(Long id) {
		claimRep.deleteById(id);
		
	}

	@Override
	public Claims updateClaim(Claims c) {
		
		return null;
	}

	@Override
	public Claims retrieveClaim(Long id) {
		
		return claimRep.findById(id).get();
	}

}
