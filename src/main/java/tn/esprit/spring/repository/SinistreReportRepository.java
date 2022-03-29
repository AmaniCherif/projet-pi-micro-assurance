package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.SinistreReport;
@Repository
public interface SinistreReportRepository extends CrudRepository<SinistreReport, Integer>{
	@Query(value = "SELECT * FROM sinistre_report WHERE claim_processing=1", nativeQuery = true)
	public List<SinistreReport> afficheRecSinTraite();
}
