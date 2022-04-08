package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.ContractOffer;

public interface ContractOfferRepository extends CrudRepository<ContractOffer, Integer>{
	@Query("select c from ContractOffer c where c.user.idUser=:idUser")
	public ContractOffer Contract_OffersByUser(@Param ("idUser") Long idUser );
	public ContractOffer findByUser_idUser(  Long idUser );
	
	public ContractOffer findByIdContractOffer(  int idUser );

}
