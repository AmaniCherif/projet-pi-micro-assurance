package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.SinistreReport;
@Repository
public interface SinistreReportRepository extends CrudRepository<SinistreReport, Integer>{
	@Query(value = "SELECT * FROM sinistre_report WHERE claim_processing=1", nativeQuery = true)
	public List<SinistreReport> afficheRecSinTraite();
	
	@Query(value="Select * from sinister_report Where date_occurance=2",nativeQuery=true)
	public SinistreReport findByDateOccuranceBetwen(Date from, Date to);
	
	@Query(value="Select * from sinister_report Where date_reclamation=2",nativeQuery=true)
	public SinistreReport findByDateReclamationBetwen(Date from, Date to);
}
