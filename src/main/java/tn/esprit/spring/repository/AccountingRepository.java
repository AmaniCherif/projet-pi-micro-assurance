package tn.esprit.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Accounting;

@Repository
public interface AccountingRepository extends JpaRepository<Accounting,Integer>{
	//resultat de lexercice
	@Transactional
	@Modifying
	@Query(value="UPDATE accounting set exercise_result=(assets-liabilities)",nativeQuery=true)
	public int exercise_result();
}
