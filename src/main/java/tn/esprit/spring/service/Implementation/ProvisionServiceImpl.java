package tn.esprit.spring.service.Implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Prime;
import tn.esprit.spring.entity.Provision;
import tn.esprit.spring.entity.SinistreReport;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.ContractRequestRepository;

import tn.esprit.spring.repository.ProvisionsRepository;
import tn.esprit.spring.repository.SinistreReportRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.IProvisionService;

@Service
public class ProvisionServiceImpl implements IProvisionService{

	@Autowired
	ProvisionsRepository provisionsRepository;
	@Autowired
	SinistreReportRepository sinistreReport;
	@Autowired
	UserRepository userRepos;
	@Autowired
	ContractRepository contractRepos;
	@Autowired
	ContractRequestRepository contractRequest;
	@Autowired
	SinistreReportServiceImpl sinistreReportServiceImpl;
	@Autowired
	TableMortaliteServiceImpl tmsi;
	
	@Override
	public List<Provision> retrieveALLProvision() {
		List<Provision> provisions =(List<Provision>)provisionsRepository.findAll();
		return provisions;
	}

	@Override
	public Provision addProvision(Provision provision) {
		provisionsRepository.save(provision);
		return provision;
	}

	@Override
	public void deleteProvision(Integer id) {
		provisionsRepository.deleteById(id);
		
	}

	@Override
	public Provision updateProvision(Provision provision) {
		provisionsRepository.save(provision);
		return provision;
	}

	@Override
	public Provision retrieveProvision(Integer id) {
		
		return provisionsRepository.findById(id).get();
	}

	
	
	
	//Calcule de provision pour le contrat Capital différé
	@Override
	public float PCD(int idSinistrereport, double i) {
		// TODO Auto-generated method stub
		Date dateactuelle= new Date();
		SinistreReport sinistrereport=sinistreReport.findById(idSinistrereport).get();
	
		double prov=0;
		float prime= sinistrereport.getContract().getPrimeCommercial();
		float capitale= sinistrereport.getContract().getReassure();
		Date birth= sinistrereport.getContract().getContractRequest().getUser().getBirthdate();
		int a=age(birth);
		//calcule de periode contract
		float p1 =(sinistrereport.getContract().getDateDebut().getYear()-sinistrereport.getContract().getDateExpiration().getYear());
		
		float p2= (dateactuelle.getYear()-sinistrereport.getContract().getDateDebut().getYear());
		
		double result=0;
		float v=(float)(1/(1+(i)));
		String sexe=sinistrereport.getContract().getContractRequest().getUser().getSexe();
		
		//Pour les femmes
		if(sexe.equalsIgnoreCase("femme"))
		{	float dp1 = tmsi.findBySurvivantsLx(a)+p1;
			float dp2 = tmsi.findBySurvivantsLx(a)+p1;
//			DonneesProvision dp1=donneesProv.findById(a+p1).get();
//			DonneesProvision dp2=donneesProv.findById(a+p2).get();
//			float lxw1=dp1.getLxW();
//			float lxw2=dp2.getLxW();
//						
			for(int j=0;j<(p1-p2);j++) 
			{
				float dp3=tmsi.findBySurvivantsLx(a)+p2+j;
				
				result=(dp3/dp2)*power(v,j);
			}
			if(sinistrereport.getContract().getPrimePure().equals(Prime.Prime_Periodique)) 
			{
				prov=(capitale*(dp1/dp2)*power(v,p1-p2))-(prime*result);
			}
			else
			{
				prov=prime;
			}
		}
		else
		{
			float dp4=tmsi.findBySurvivantsLx(a)+p1;
			float dp5=tmsi.findBySurvivantsLx(a)+p2;
//			float lxm1=dp4.getLxM();
//			float lxm2=dp5.getLxM();
//			
			for(int j=0;j<(p1-p2);j++)
			{
				float dp6=tmsi.findBySurvivantsLx(a)+p2+j;
//				float lxm3=dp6.getLxM();
				result=(dp6/dp5)*power(v,j);
			}
			if(sinistrereport.getContract().getPrimePure().equals(Prime.Prime_Periodique))
			{
				prov=(capitale*(dp4/dp5)*power(v,p1-p2))-(prime*result);
			}
			else
			{
				prov=prime;
			}
		}

		return (float) prov;
		
	}
	
	
	
	//provision contrat Vie entière
	public double PCVE(int idSinistrereport, double i) {
		Date dateactuell=new Date();
		SinistreReport sinistrereport=sinistreReport.findById(idSinistrereport).get();
		
		double prov=0;
		//float prime=sinistrereport.getContract().getContractRequest().getUser().getInvestment().getPrime_unique();
		float prime=sinistrereport.getContract().getPrimeCommercial();
		float capital=sinistrereport.getContract().getReassure();
		Date birth= sinistrereport.getContract().getContractRequest().getUser().getBirthdate();
		int a=age(birth);
		//Formule mathématique
		int ag=104;//Age maximum
		float v= (float) (1/(1+(i)));
		float p2= (dateactuell.getYear()-sinistrereport.getContract().getDateDebut().getYear());
		String sexe=sinistrereport.getContract().getContractRequest().getUser().getSexe();
		double result1=0;
		double result2=0;
		
		//Calcule pour femme
		if(sexe.equalsIgnoreCase("Women")) 
		{
			float dp1 = tmsi.findBySurvivantsLx(a)+p2;
			//DonneesProvision dp1=donneesProv.findById(a+p2).get();
			//float lxw1=dp1.getLxW();
			
			for(int j=0;j<(ag-a-p2);j++) 
			{	float dp2=tmsi.findBySurvivantsLx(a)+p2+j;
				//DonneesProvision dp2=donneesProv.findById(a+p2+j).get();
				//float dx1=dp2.getDxW();
				result1=(float)((dp2/dp1)*power(v,j+(1/2)));
			}
			
			for(int j=0;j<(ag-a-p2);j++) 
			{
				float dp3=tmsi.findBySurvivantsLx(a)+p2+j;
				//float lxw2=dp3.getLxW();
				result2=(dp3/dp1)*power(v,j);
			}
			if(sinistrereport.getContract().getPrimePure().equals(Prime.Prime_Periodique)) 
			{
				prov=(capital*result1)-(prime* result2);
			}
			else
			{
				prov=prime;
			}
			return prov;
		}
		
		//pour homme
		else
		{
			if(sexe.equals("Men")) 
			{
				float dp1 = tmsi.findBySurvivantsLx(a)+p2;
				//DonneesProvision dp1=donneesProv.findById(a+p2).get();
				//float lxw1=dp1.getLxW();
				
				for(int j=0;j<(ag-a-p2);j++) 
				{	float dp2=tmsi.findBySurvivantsLx(a)+p2+j;
					//DonneesProvision dp2=donneesProv.findById(a+p2+j).get();
					//float dx1=dp2.getDxW();
					result1=(float)((dp2/dp1)*power(v,j+(1/2)));
				}
				
				for(int j=0;j<(ag-a-p2);j++) 
				{
					float dp3=tmsi.findBySurvivantsLx(a)+p2+j;
					//float lxw2=dp3.getLxW();
					result2=(dp3/dp1)*power(v,j);
				}
				if(sinistrereport.getContract().getPrimePure().equals(Prime.Prime_Periodique)) 
				{
					prov=(capital*result1)-(prime* result2);
				}
				else
				{
					prov=prime;
				}
				
			}
		}
		
		return prov;
	}
	
	
	//provision contrat rente viagere
	public double PCRV(int idSinistrereport, double i) {
		
		Date dateactuelle= new Date();
		SinistreReport sinistrereport=sinistreReport.findById(idSinistrereport).get();
		double prov=0;
		float prime=sinistrereport.getContract().getPrimeCommercial();
		float capital=sinistrereport.getContract().getReassure();
		Date birth=sinistrereport.getContract().getContractRequest().getUser().getBirthdate();
		int a=age(birth);
		int p1=(sinistrereport.getContract().getDateExpiration().getYear())-(sinistrereport.getContract().getDateDebut().getYear());
		int p2=(dateactuelle.getYear())- (sinistrereport.getContract().getDateDebut().getYear());
		int ag=104;
		float v=(float)(1/(1+(i)));
		double result1=0;
		double result2=0;
		String sexe=sinistrereport.getContract().getContractRequest().getUser().getSexe();
		//les Femmes
		if(sexe.equalsIgnoreCase("Women"))
		{
			float dp1=tmsi.findBySurvivantsLx(a)+p2;
			//float lxw1=dp1.getLxW();
			
			for(int j=p1;j<(ag-a-p2);j++)
			{
				float dp2=tmsi.findBySurvivantsLx(a)+p2+j;
				//float lxw2=dp2.getLxW();
				result1=(dp2/dp1)*power(v,j);
			}
			for(int j=0;j<(p1-p2);j++)
			{
				float dp3=tmsi.findBySurvivantsLx(a)+p2+j;
				//float lxw3=dp3.getLxW();
				result2=(dp3/dp1)*power(v,j);
			}
			if(sinistrereport.getContract().getPrimePure().equals(Prime.Prime_Periodique))
			{
				prov=(capital*result1)-(prime*result2);
			}
			else
			{
				prov=prime;
			}
			return prov;
		}
		else
		{
			float dp1=tmsi.findBySurvivantsLx(a)+p2;
			//float lxm1=dp1.getLxM();
			
			for(int j=p1;j<(ag-a-p2);j++)
			{
				float dp2=tmsi.findBySurvivantsLx(a)+p2+j;
				//float lxm2=dp2.getLxM();
				result1=(dp2/dp1)*power(v,j);
			}
			for(int j=0;j<(p1-p2);j++)
			{
				float dp3=tmsi.findBySurvivantsLx(a)+p2+j;
				//float lxm3=dp3.getLxM();
				result2=(dp3/dp1)*power(v,j);
			}
			if(sinistrereport.getContract().getPrimePure().equals(Prime.Prime_Periodique))
			{
				prov=(capital*result1)-(prime*result2);
			}
			else
			{
				prov=prime;
			}
			return prov;
		}
	}

	//Calcule d'age de la date naissance
		public int age(Date birthDate) {
			Date dateactuelle= new Date();
			DateFormat format= new SimpleDateFormat("JJMMAAAA");
			int dB=Integer.parseInt(format.format(birthDate));//date de naissance
			int dA=Integer.parseInt(format.format(dateactuelle));//date Actuelle
			int age=(dA - dB);
			return age;
		}
		
	//Calcule power
		public static double power(double i, double p) {
			double var1=i;
			double var2=Math.log((var1));
			double var3=var2*p;
			double taux=Math.exp(var3);
			return taux;
					
		}

}
