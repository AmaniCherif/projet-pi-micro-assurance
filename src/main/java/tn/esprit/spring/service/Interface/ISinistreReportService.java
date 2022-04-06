package tn.esprit.spring.service.Interface;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.SinistreReport;

public interface ISinistreReportService {

	List<SinistreReport> retrieveALLSinistreReport();
	SinistreReport addSinistreReport(SinistreReport sinistreReport);
	void deleteSinistreReport(Integer id);
	SinistreReport updateSinistreReport(SinistreReport sinistreReport);
	SinistreReport retrieveSinistreReport(Integer id);
	SinistreReport findSinistreReportByDateOccurance(Date from, Date to);
	SinistreReport findSinistreReportByDateReclamation(Date from, Date to);

}
