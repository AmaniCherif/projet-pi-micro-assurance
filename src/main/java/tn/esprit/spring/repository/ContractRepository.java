
package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.User;


@Repository
public interface ContractRepository  extends CrudRepository<Contract, Long>{
    List<Contract> findByState(String state);
	List<Contract> findByAcceptReq(int acceptReq);

	@Query(value = "SELECT * FROM contrat INNER JOIN contract_request ON contrat.contract_request_id=contract_request.id WHERE acceptation=1 and contract_request.users_user_id=:w ORDER BY date_debut ASC", nativeQuery = true)
	public List<Contract> LesContratsClient(@Param("w") Long w);
//	@Query(value = "SELECT * FROM contrat INNER JOIN demande_contrat ON contrat.demande_contrat_id=demande_contrat.id WHERE acceptation=1 and demande_contrat.users_user_id=:w", nativeQuery = true)
//	public List<Contract> Contrataccepter(@Param("w") int w);
//	@Query(value = "SELECT * FROM contrat INNER JOIN demande_contrat ON contrat.demande_contrat_id=demande_contrat.id WHERE acceptation=0 and demande_contrat.users_user_id=:w", nativeQuery = true)
//	public List<Contract> ProposeContrat(@Param("w") int w);


	List <Contract> findByUser(User u);

	



}
