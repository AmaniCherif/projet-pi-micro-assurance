package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.entity.SinistreReport;
import tn.esprit.spring.repository.SinistreReportRepository;
import tn.esprit.spring.service.Interface.ISinistreReportService;

public class SinistreReportServiceImpl implements ISinistreReportService{

	@Autowired
	SinistreReportRepository sinistreReportRepository;
	
	@Override
	public List<SinistreReport> retrieveALLSinistreReport() {
		List<SinistreReport> sinistreReports =(List<SinistreReport>)sinistreReportRepository.findAll();
		return sinistreReports;
	}

	@Override
	public SinistreReport addSinistreReport(SinistreReport sinistreReport) {
		sinistreReportRepository.save(sinistreReport);
		return sinistreReport;
	}

	@Override
	public void deleteSinistreReport(Integer id) {
		sinistreReportRepository.deleteById(id);
	}

	@Override
	public SinistreReport updateSinistreReport(SinistreReport sinistreReport) {
		sinistreReportRepository.save(sinistreReport);
		return sinistreReport;
	}

	@Override
	public SinistreReport retrieveSinistreReport(Integer id) {
		
		return sinistreReportRepository.findById(id).get();
	}

	
}
