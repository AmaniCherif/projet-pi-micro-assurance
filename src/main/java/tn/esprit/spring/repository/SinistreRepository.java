package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Sinistre;



@Repository
public interface SinistreRepository extends CrudRepository<Sinistre, Integer>{
	
	/*List<Sinistre> findSinistreByState(State_Sinistre_Claim state_Sinistre_Claim);
	int findContractRequestDurationBySinistre(Integer id,ContractType str);
	List<Sinistre> findSinistresByStateReclamation();*/
	@Query(value = "SELECT * FROM Sinistre WHERE extract(year from date_reglement)=:s ", nativeQuery = true)
	public List<Sinistre> findbyDateReglement(@Param("s") int s );
	@Query(value = "SELECT * FROM sinistre  ORDER BY date_reglement ASC", nativeQuery = true)
	public List<Sinistre> mindate();

	@Query(value = "SELECT * FROM sinistre  ORDER BY date_reglement DESC", nativeQuery = true)
	public List<Sinistre> maxdate();


}
