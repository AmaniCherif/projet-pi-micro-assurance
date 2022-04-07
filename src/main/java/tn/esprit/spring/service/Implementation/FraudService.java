package tn.esprit.spring.service.Implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.Prime;
import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.ContractRequestRepository;
import tn.esprit.spring.repository.IActifFinancier;
import tn.esprit.spring.repository.IFraudRepo;
import tn.esprit.spring.repository.SinistreReportRepository;
import tn.esprit.spring.repository.SinistreRepository;
import tn.esprit.spring.entity.Fraud;
//yosser


@Service
public class FraudService {
	@Autowired
	IActifFinancier actifs ;
	@Autowired
	SinistreReportRepository reclamations ;
	@Autowired
	SinistreRepository sinistre ;
	@Autowired
	ContractRepository contrats ;
	@Autowired
	ContractRequestRepository demandeContrat ;
	@Autowired
    IFraudRepo Fraud ;

	public void verifFraud(Long idUser){
		Fraud f = new Fraud();
		f.setValide("Verifer ce contrat !");
		f.setNiveau(0);
		List<Contract> contrat = (List<Contract>) contrats.findAll();
		for(Contract c : contrat){
			if(c.getContractRequest().getChoixPrime() == Prime.Prime_Unique){
				if ( c.getPrimeCommercial() > 1000){
					f.setCause("le montant de la prime est un peu grand par rapport au salire " + c.getContractRequest().getUser().getCin()  );
				}
			}
			if(c.getContractRequest().getChoixPrime() == Prime.Prime_Unique){
				if ( c.getPrimeCommercial() > 2500){
					f.setCause("le montant de la prime est un peu grand par rapport au salire " + c.getContractRequest().getUser().getCin()  );
				}
			}
			if ( c.getPrimeCommercial() > 3 * c.getContractRequest().getUser().getSalary()){
				f.setCause("le montant de la prime est un peu grand par rapport au salire " + c.getContractRequest().getUser().getCin()  );
			}
			if ( c.getReassure() > 20 * c.getContractRequest().getUser().getSalary()){
				f.setCause("le montant de remboursement est un peu grand par rapport au salire " + c.getContractRequest().getUser().getCin()  );
			}
			if ( c.getReassure() > 20 * c.getContractRequest().getUser().getSalary()){
				f.setCause("le montant de remboursement est un peu grand par rapport au salire " + c.getContractRequest().getUser().getCin()  );
			}
			if ( c.getReassure() > 20 * c.getContractRequest().getUser().getSalary()){
				f.setCause("le montant de remboursement est un peu grand par rapport au salire " + c.getContractRequest().getUser().getCin()  );
			}
		}	
	}
	
	public void verifMontantContratFraud(Contract c){
		Fraud f = new Fraud();
		f.setValide("Verifer ce contrat !");
		f.setNiveau(0);
	
		if(c.getContractRequest().getChoixPrime() == Prime.Prime_Unique){
			if ( c.getPrimeCommercial() > 1000){
				f.setCause("le montant de la prime est un peu grand par rapport au salaire bro Attention!" + c.getContractRequest().getUser().getCin()  );
			
			}
		}
		if(c.getContractRequest().getChoixPrime() == Prime.Prime_Unique){
			if ( c.getPrimeCommercial() > 2500){
				f.setCause("le montant de la prime est un peu grand par rapport au salaire bro Attention! " + c.getContractRequest().getUser().getCin()  );
			}
		}
	
		Fraud.save(f);	
	}

    	public void verifNombreContratFraud(Contract c){
		Fraud f = new Fraud();
		f.setValide("Verifer ce contrat !");
		f.setNiveau(0);
		Long user = c.getContractRequest().getUser().getIdUser();	
		List<Contract> cont =  contrats.LesContratsClient(user);
		System.out.println(" annnneeeeeee   " + cont.get(0).getDateDebut());
		if(cont.get(0).getDateDebut().getYear() == c.getDateDebut().getYear()  || cont.get(1).getDateDebut() == c.getDateDebut()  ){
			f.setCause("Plus que 2 police d assurance dans la meme annee" + c.getContractRequest().getUser().getCin()  );
		}	
		Fraud.save(f);	
    	}
    	
	public void verifRachatTotalFraud( Sinistre s){
		String rT = "rachat total";
		Fraud f = new Fraud();
		f.setValide("Verifer ce contrat !");
		f.setNiveau(0);
		if(s.getSinistreReport().getSinistre_type() == rT){
			if (s.getDate_Payment().getYear() - s.getSinistreReport().getContract().getDateDebut().getYear() <= 2){
				f.setCause("Rachat totale avant 2 ans .. c est tot mec !"  );

			}
		}
		Fraud.save(f);	
	}
	
	public void verifRachatPartielFraud( Sinistre s){
		String rP = "rachat partiel";
		Fraud f = new Fraud();
		int somme = 0 ;
		f.setValide("Verifer ce contrat !");
		f.setNiveau(0);
		Long user = s.getSinistreReport().getContract().getContractRequest().getUser().getIdUser();
		if(s.getSinistreReport().getSinistre_type() == rP){
			List<Sinistre> l = 	(List<Sinistre>) sinistre.findAll();
			for(Sinistre sin: l){
				if(sin.getSinistreReport().getContract().getContractRequest().getUser().getIdUser() == user){
					somme=somme+1;
				}
			}		
				if(somme > 2){
					f.setCause("Rachat partiel plus de 2 fois .. c est beaucoup mec !"  );
				}	
			}
		Fraud.save(f);	
	}	
	
        	public void verifBeneficiareFraud(Contract c ){
     		Fraud f = new Fraud();
     		f.setValide("Verifer ce contrat !");
    		f.setNiveau(0);
    		Long user = c.getContractRequest().getUser().getIdUser();
	    	List<Contract> cont =  contrats.LesContratsClient(user);
      		if(cont.get(0).getContractRequest().getCinBeneficiary()!= cont.get(0).getContractRequest().getUser().getCin()){
			f.setCause("le souscripteur n'est pas le beneficiaire .. vous devez verifer mec !"  );
		}
		Fraud.save(f);		
	}

}



