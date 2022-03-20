package tn.esprit.spring.service.Implementation;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.entity.Prime;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.ContractRequestRepository;
import tn.esprit.spring.service.Interface.ContractService;
@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	ContractRepository contractRep;
	
	@Autowired
	ContractRequestRepository contractRequest;
	
	@Autowired
	DataServiceImpl dataService;
	
	//CONTRATS EN CAS DE VIE
	String CapitalDiffere = "capital differe";
	String renteViagere = "Rente viagère";
	//CONTRATS EN CAS DE DECé
	String vieEntiere ="Vie Entiere";
	
	Prime primeUnique = Prime.Prime_Unique ;
	Prime primePeriodique =  Prime.Prime_Periodique;
	
	@Override
	public List<Contract> retrieveALLContracts() {
		List<Contract> contract=(List<Contract>) (contractRep.findAll());
		return contract;
	}


	@Override
	public void deleteContract(int ref_contrat) {
		contractRep.deleteById(ref_contrat);
		
		
	}
	
	// faire le calcul et la tarification , si l assurance accpete la demande (elle peut refuser)
	public void tarificationContrat(int id) {
		
		System.out.println(id);
		ContractRequest d = contractRequest.findById(id).get();
		System.out.println("okhrej ay");
		double interet = 0.002; /// 0.2 % j'ai choisis le taux d'interet 2% 
		String sexe = d.getUser().getSex();
		int age = age(d.getUser().getBirthdate());
		double frais = 0.03;// on va considerer tous les frais du contrat .. 3 %
		//Date currentUtilDate = new Date();
		Date currentUtilDate = d.getDateRequest();
		
		int a = currentUtilDate.getYear() + d.getDuration();		
		Date currentUtilDate2 = new Date();
		currentUtilDate2.setYear(a);
		String nomContract = d.getNomContract();
		System.out.println("okhrej ay");
		if ( (2000*10) == d.getCapitalAssure() ) {
			String s ="votre demande est annulé , votre salaire "
					+ "ne peut pas supporter votre demande de capital assuré";
			d.setReaseon(s);
			contractRequest.save(d);
			System.out.println(s);}
		
		else {
		///// on va faire ici le calcule de tarification , on va considerer 1 pour chaque valeur 
			Contract c = new Contract();
			c.setState("en cours");
			c.setContractRequest(d);
			c.setDateDebut(currentUtilDate);
			c.setDateExpiration(currentUtilDate2);
			c.setAcceptReq(0);
			
		//Un assuré d’âge lx à t = 0 souhaite recevoir un capital S, n années plus tard s’il est encore en vie à cette époque. 
			//Capital differe sans contre assurance

			
		if(d.getNomContract().equals(CapitalDiffere)){  // choix du contrat
			if(d.getChoixPrime().equals(primeUnique)){ // choix type de prime 		
					if(d.getCapitalAssure() != 0){ // on a  ici calculer le capital demande et on va calculé les primes
		//public double calculePUCapital_vieCapital(float capital ,int age , int annee, double interet , String sexe){
						double calculPUCapital_viePrime = dataService.calculePUCapital_vieCapital(d.getCapitalAssure(),age, d.getDuration(),interet, sexe) ;
						c.setReassure(d.getCapitalAssure());
						c.setPrimePure((float) calculPUCapital_viePrime);
						//Prime pure + frais de gestion
						c.setPrimeCommercial((float) (calculPUCapital_viePrime+calculPUCapital_viePrime*frais)) ; 
						
					}
			}
		}
		}	
	}
	
	/* calcul de l'age depuis la date de naissance*/
	public int age(Date birthdate){
		Date currentDate = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd"); 
		int d1 = Integer.parseInt(formatter.format(birthdate));                            
		int d2 = Integer.parseInt(formatter.format(currentDate));                          
		int age = (d2 - d1) / 10000; 
		System.out.println("voici l'age:"+age);
		return age;
	}

	@Override
	public Contract addContract(Contract contract) {
		contractRep.save(contract);
		return contract;
	}
	
	@Override
	public Contract updateContract(Contract contract) {
		return null;
	}

	public Contract retrieveContract(int ref_contrat) {
		return contractRep.findById(ref_contrat).get();
	}
}
