package tn.esprit.spring.service.Implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.Prime;
import tn.esprit.spring.entity.SinistreReport;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.ProvisionsRepository;
import tn.esprit.spring.repository.SinistreReportRepository;
import tn.esprit.spring.service.Interface.IProvisionService;
import tn.esprit.spring.service.Interface.ISinistreReportService;
@Service
public class SinistreReportServiceImpl implements ISinistreReportService{

	@Autowired
	SinistreReportRepository sinistreReportRepository;
	@Autowired
	ContractRepository contractRepository;
	@Autowired
	ProvisionsRepository provisionsRepository;
	@Autowired
	IProvisionService iProvisionService;
	@Autowired
	ContractServiceImpl contractServiceImpl;
	
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

	@Override
	public SinistreReport findSinistreReportByDateOccurance(Date from, Date to) {
		
				return sinistreReportRepository.findByDateOccuranceBetwen(from, to);
	}

	@Override
	public SinistreReport findSinistreReportByDateReclamation(Date from, Date to) {
		
		return sinistreReportRepository.findByDateReclamationBetwen(from, to);
	}

	//calcule rachat Partial
	
	public float CalculPartialBuyback(int idSinistreReport) {
		double i=0;
		Date dateactuel=new Date();
		SinistreReport sinistreReport=sinistreReportRepository.findById(idSinistreReport).get();
		Contract contract=sinistreReport.getContract();
		float capital=0;
		float capitaltotal=(float)capitale(sinistreReport.getId_Sinistre_Report(),i);
		float versement= primetotal(sinistreReport.getId_Sinistre_Report());
		float buyback=sinistreReport.getPartial_buyback();
		float gains=buyback-((versement*buyback)/capitaltotal);
		int duration=(dateactuel.getYear())-(contract.getDateDebut().getYear());
		//Les impots sur le gains
		if(duration<10 && duration>=0)
		{
			float impot=(float)(gains*0.7);
			capital=buyback-impot;
		}
		else if(duration>=10)
		{
			float impot=(float)(gains*0.55);
			capital=buyback-impot;
		}
		else
			capital=0;//pas de remboursement
		if(contract.getContractRequest().getNomContract().equalsIgnoreCase("rente viagere"))
			contract.setReassure(contract.getReassure()-(contract.getReassure()*capital/contract.getPrimeCommercial()));
		else
			contract.setReassure(contract.getReassure()-capital);
		return capital;
	}
	
	//calcule rachat totale
	
	public float CalculTotalBuyBack(int idSinistreReport) {
		double i=0;
		float prov=0;
		
		double pcrv=iProvisionService.PCRV(idSinistreReport, i);
		double pccd=iProvisionService.PCD(idSinistreReport, i);
		double pcve=iProvisionService.PCVE(idSinistreReport, i);
		float capital=0;
		Date dateactuel= new Date();
		
		SinistreReport sinistreReport=sinistreReportRepository.findById(idSinistreReport).get();
		Contract contract=sinistreReport.getContract();
		int duration=dateactuel.getYear()- contract.getDateDebut().getYear();
		//Provision rente viagere
		if(contract.getContractRequest().getNomContract().equalsIgnoreCase("rente viagere"))
		{
			prov= (float)pcrv;
		}
		//provision capital differe
		else if(contract.getContractRequest().getNomContract().equalsIgnoreCase("capital differe"))
		{
			prov=(float)pccd;
		}
		//provision cie entiere
		else if (contract.getContractRequest().getNomContract().equalsIgnoreCase("vie entire"))
		{
			prov=(float) pcve;
		}
		if(duration<1) 
		{
			capital=0;
		}
		else if((duration>=1)&&(duration<10)) 
		{
			double impot=prov-(prov*0.05);//frais
			capital=(float)impot;
		}
		else
			capital=prov;
		return capital;
	}

	

	public double capitale(int idSinistreReport, double i) {
		
		Date dateactuel=new Date ();
		SinistreReport sinistreReport=sinistreReportRepository.findById(idSinistreReport).get();
		double valueraquise=0;
		int duration=(dateactuel.getYear())-(sinistreReport.getContract().getDateDebut().getYear());
		double prime=sinistreReport.getContract().getPrimeCommercial();
		if(sinistreReport.getContract().getPrimePure().equals(Prime.Prime_Periodique))
			valueraquise=prime*((power((1+i),duration)-1)/i);
		else
			valueraquise=prime*(power((1+i),duration));
		return valueraquise;
	}
	
	public float primetotal(int idSinistreReport) {
		SinistreReport sinistreReport=sinistreReportRepository.findById(idSinistreReport).get();
		Date dateactuel=new Date();
		int duration=0;
		float primetotal=0;
		if(sinistreReport.getContract().getPrimePure().equals(Prime.Prime_Periodique))
			primetotal=duration*(sinistreReport.getContract().getPrimeCommercial());
		else
			primetotal=sinistreReport.getContract().getPrimeCommercial();
		return primetotal;
		
	}
	public static double power(double i, double p) {
		double var1=i;
		double var2=Math.log((var1));
		double var3=var2*p;
		double taux=Math.exp(var3);
		return taux;
				
	}

	
	
	
}
