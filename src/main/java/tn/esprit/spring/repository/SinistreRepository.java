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
	@Query(value = "SELECT * FROM Sinistre WHERE extract(year from date_payment)=:s ", nativeQuery = true)
	public List<Sinistre> findbyDateReglement(@Param("s") int s );
	@Query(value = "SELECT * FROM sinistre  ORDER BY date_payment ASC", nativeQuery = true)
	public List<Sinistre> mindate();

	@Query(value = "SELECT * FROM sinistre  ORDER BY date_payment DESC", nativeQuery = true)
	public List<Sinistre> maxdate();
	@Query(value = "SELECT * FROM sinistre s JOIN sinistre_report r on s.sinistre_report_id=r.id JOIN contract c on r.contract_id=c.id JOIN contract_request d on c.contract_request_id=d.id JOIN user u on d.users_user_id=u.user_id WHERE u.user_id=:us", nativeQuery = true)
	public List<Sinistre> IafficheSinUser(@Param("us") int us);
}
