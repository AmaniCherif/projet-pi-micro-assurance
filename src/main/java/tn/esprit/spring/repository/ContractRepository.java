
package tn.esprit.spring.repository;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.User;


@Repository
public interface ContractRepository  extends CrudRepository<Contract, Long>{
    List<Contract> findByState(String state);
	List<Contract> findByAcceptReq(int acceptReq);

	List <Contract> findByUser(User u);

	


}
