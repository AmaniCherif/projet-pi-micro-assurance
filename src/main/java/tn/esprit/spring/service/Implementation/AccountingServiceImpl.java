package tn.esprit.spring.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.entity.Accounting;
import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.ReinsuranceContract;
import tn.esprit.spring.entity.SinistreReport;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.AccountingRepository;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.ReinsuranceContractRepository;
import tn.esprit.spring.repository.SinistreReportRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.AccountingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class AccountingServiceImpl implements AccountingService{
	@Autowired
	AccountingRepository accountingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ContractRepository contractRepository;
	@Autowired
	SinistreReportRepository reclamationRepos;
	@Autowired
	ReinsuranceContractRepository reinsuranceRepos;

	private static final Logger l = LogManager.getLogger(EmployeeSalaryServiceImpl.class);
	@Override
	public List<Accounting> retrieveAllAccountings() {
		List<Accounting> accountings = (List<Accounting>) accountingRepository.findAll();
		for(Accounting accounting : accountings)
		{
			l.info("accounting ++ :"+accounting);
		}
		return accountings;

	}
	@Override
	public Accounting addAccounting(Accounting s) {
		 
		
		return accountingRepository.save(s);
	}
	@Override
	public void deleteAccounting(String id) {
		accountingRepository.deleteById(Integer.parseInt(id));
		
	}
	@Override
	public Accounting updateAccounting(Accounting s) {
		Accounting accountingAdded = accountingRepository.save(s);
		return accountingAdded;
	}
	@Override
	public Accounting retrieveAccounting(String id) {
		l.info("in retrieveAccounting id= "+id);
		Accounting s = accountingRepository.findById(Integer.parseInt(id)).orElse(null);
		l.info("Accounting returned : " +s);
		return s;

	}
	@Override
	public void affecterAccountingToUser(int idp, Long id) {
		Accounting accounting = accountingRepository.findById(idp).get();
		User user = userRepository.findById(id).get();
		if (!ObjectUtils.isEmpty(accounting) && !ObjectUtils.isEmpty(user))
			accounting.setUser(user);
		userRepository.save(user);
	}
	
	@Override
	public int exercise_result() {
		return accountingRepository.exercise_result();
	}
	@Override
	public float assets(){
		//primes commerciales
				float a = 0; //revenus mta3 l assurance
				float autredettes=10000;
				float autrescreances=50000;
				List<Contract> list = contractRepository.findByState("en cours"); //les contrats en cours
				Iterator<Contract> it = list.iterator();
				while (it.hasNext()) {
					a+=it.next().getPrimeCommercial(); //elli en cours ye5edh alihom prime kemel
				}
				//Quote_share reinsurance
				float sc = 0; //revenu de réassurance
				List<ReinsuranceContract> listr = reinsuranceRepos.findAll(); //bech ye5edh les contrats lkol
				Iterator<ReinsuranceContract> itr = listr.iterator();
				while (itr.hasNext()) {
					sc+=itr.next(). getCommerPrem()*0.3; //pour chaque contract va prendre un prime(0.3 (ratio)benéfice facteur comparatif)
				}
				float actifs=a+sc+autrescreances;

				return actifs;
	}
	@Override
	public float liabilities() {
		//9adech 5asrou flous 3al les assurés
		float a =0;
		float autredettes=10000;
		float f=0;
		List<SinistreReport> listp = reclamationRepos.afficheRecSinTraite(); //liste des reclamations
		Iterator<SinistreReport> itt = listp.iterator();
		while (itt.hasNext()) {
			f+=itt.next().getSinistre_fees();
		}
		float passifs=f+autredettes;
		return passifs; //charges
	}
	
	@Override
	public float totalPrimeCom() {
		//9adech da5let flous liha teb3a l actif
		float s =0;
		List<Contract> list = contractRepository.findByState("en cours");
		Iterator<Contract> it = list.iterator();
		while (it.hasNext()) {
			s+=it.next().getPrimeCommercial();
		}

		return s;

	}	
	@Override
	public float totalFrais() {
		//la somme versé aux assurés
		float s =0;
		List<SinistreReport> list = reclamationRepos.afficheRecSinTraite();
		Iterator<SinistreReport> it = list.iterator();
		while (it.hasNext()) {
			s+=it.next().getSinistre_fees();
		}		 
		return s;

	}
	@Override
	//Quote_Part reinsurance 
	public float ReinsuranceComm() {
		float sc =0;
		List<ReinsuranceContract> list = reinsuranceRepos.findAll();
		Iterator<ReinsuranceContract> it = list.iterator();
		while (it.hasNext()) {
			sc+=it.next().getCommerPrem()*0.3;
		}

		return sc;

	}
	/*************************Résultat de l'exercice***********************************************/
	@Override
	public String Resultat() {
		//primes commerciales
		float a =0;
		float autredettes=10000;
		float autrescreances=50000;
		List<Contract> list = contractRepository.findByState("en cours");
		Iterator<Contract> it = list.iterator();
		while (it.hasNext()) {
			a+=it.next().getPrimeCommercial();
		}


		//Quote_share reinsurance
		float sc =0;
		List<ReinsuranceContract> listr = reinsuranceRepos.findAll();
		Iterator<ReinsuranceContract> itr = listr.iterator();
		while (itr.hasNext()) {
			sc+=itr.next().getCommerPrem()*0.3;
		}
		float actifs=a+sc+autrescreances;


		//frais
		float f=0;
		List<SinistreReport> listp = reclamationRepos.afficheRecSinTraite();
		Iterator<SinistreReport> itt = listp.iterator();
		while (itt.hasNext()) {
			f+=itt.next().getSinistre_fees();
		}
		float passifs=f+autredettes;

		
		
		//Resultat de lexercice
		float resultat= actifs-passifs;
		if (resultat<0)  {
			return ("L'assurance a pour actifs total=  "+actifs+"\n" +"  L'assurance a pour passifs total =  "+passifs+"\n"+"donc le resultat de l'exercice =  "+resultat+"\n"+"Par consequent l'assurance est non solvable");

		}
		else
		{
		
		return ("L'assurance a pour actifs total=  "+actifs+"\n" +"  L'assurance a pour passifs total =  "+passifs+"\n"+" donc le resultat de l'exercice =  "+resultat+"\n"+"Par consequent l'assurance est solvable");
		}
	}
	

	
	@Transactional
	public List<Contract> afficheContrat(){return (List<Contract>) contractRepository.findAll();}

	@Override
	public float prevision(Date d) {
		Date currentDate = new Date();
		float prevision=0;
		List<Contract> contract= contractRepository.findByAcceptReq(1);
		for (Contract c : contract ){
			int nb= d.getYear()- c.getDateDebut().getYear();
			if((c.getDateExpiration().getYear()-currentDate.getYear() )>1){
				if(nb>1)
				{ 
					prevision=prevision + nb* c.getPrimeCommercial();
				}
				else if (nb==1)
				{
					prevision=prevision+ c.getPrimeCommercial();
				}
				else
				{
					prevision=0;
				}
			}
		}

		return prevision;
	}
}
