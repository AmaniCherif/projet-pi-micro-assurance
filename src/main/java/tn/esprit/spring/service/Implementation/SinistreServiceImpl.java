package tn.esprit.spring.service.Implementation;

import java.util.Date;

import java.text.ParseException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Sinistre;
import tn.esprit.spring.entity.State_Sinistre_Claim;
import tn.esprit.spring.repository.SinistreRepository;
import tn.esprit.spring.service.Interface.ISinistreService;


@Service
public class SinistreServiceImpl implements ISinistreService{

	@Autowired
	SinistreRepository ssi;

	@Override
	public List<Sinistre> retrieveALLSinistre() {
		List<Sinistre> sinistres= (List<Sinistre>)ssi.findAll();
		return sinistres;
	}

	@Override
	public Sinistre addSinistre(Sinistre s) {
		ssi.save(s);
		return s;
	}

	@Override
	public void deleteSinistre(Integer id) {
		ssi.deleteById(id);
		
	}

	@Override
	public Sinistre updateSinistre(Sinistre s) {
		ssi.save(s);
		return s;
	}

	@Override
	public Sinistre retrieveSinistre(Integer id) {
		
		return ssi.findById(id).get();
	}

	@Override
	public String flowSinistre(int idSinistre) {
		Sinistre sinistre=ssi.findById(idSinistre).orElse(null);
		if(sinistre.getState_Sinistre_Claim().equals("Invalid"))
		{
			return "Le Sinistre déclaré "+sinistre.getSinistreReport().getDate_reclamation()+" est rejecté"; 
		}
		else
			
		return "Le dossier sinistre est en traitrement";
	}

	@Override
	public String TimeLimitVerification(int idSinistre) {
		double Nbday=0;
		String message=null;
		Sinistre sinistre=ssi.findById(idSinistre).orElse(null);
		
		Date dec=sinistre.getSinistreReport().getDate_reclamation();
		Date occ=sinistre.getSinistreReport().getDate_Occurance();
		int delaidec=30;
		if(Nbday<=delaidec)
		{
			message="Bienvenue! Le delai est bien respecté";
		}
		else
			message="Bienvenue! Le delai n'est pas respecté, damande rejeté";
		return message;
	}

	
}
//	@Override
//	public float TDEMPRUNTEUR(Long idS) throws ParseException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public float CreditSimulator(Long idS, Long idC) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}

/*	
	@Override
	public List<Sinistre> findByState(State_Sinistre_Claim state_Sinistre_Claim) {
		

		return sinistreRepository.findSinistreByState(state_Sinistre_Claim);
	}
}*/


//
//
//	/* public float TDEMPRUNTEUR(Long idS) {
//			int k;
//			float prime = 0;
//			int s = 0;
//			Long m = 0L ;
//			sinister ss = sinistreRepository.findById(idS).get();
//			m = sinistreRepository.findcontractidbysisnTDEMPREUNTEUR(idS);
//			User u =ss.getUser();
//			Contract c = cr.findById(m).get();
//			double taux = c.getRate();
//			Calendar calendar = new GregorianCalendar();
//			calendar.setTime(u.getBirthdate());
//			int BDay = calendar.get(Calendar.YEAR);
//			LocalDate now = LocalDate.now();
//			int years = now.getYear()-BDay;
//			int o = findcontractdurationBysinister(m,c.getType()) ; 
//			L.info("OOOOO"+o ) ;
//			float crd = 0 , crd1 = 0 , tde = 0;
//			L.info("TYPESINISTRE"+ss.getTypeSinistre().toString() ) ;
//			L.info("TYPECONTRAT"+c.getType().toString()) ;
//			if (ss.getTypeSinistre().toString().equals(c.getType().toString()))
//			{
//				 s = findcontractdurationBysinister(m,c.getType()) ; 
//				 L.info("SSSS"+s ) ;
//				
//			}
//			for (k =0; k < ((s-1)*12) ; k++) {
//				 //double v = Math.pow((1+(taux/12)) ,  s*12 );
//				//double l = Math.pow( 1/ (1+(taux/12)) ,  s*12 - 1 );
//				//prime = ((float) (Math.pow((1+(taux/12)) ,  s*12 )) * c.getPrice()) - (float)(Math.pow((1+(taux/12)) ,  s*12 )) ;	
//				//crd = (float) (((float) (Math.pow((1+(taux/12)) ,  s*12 )) * c.getPrice()) - (float)(Math.pow((1+(taux/12)) ,  s*12 )) / Math.pow( 1/ (1+(taux/12)) ,  s*12 - 1 )) ; 
//				//crd1 = (float) ((float) (((float) (Math.pow((1+(taux/12)) ,  s*12 )) * c.getPrice()) - (float)(Math.pow((1+(taux/12)) ,  s*12 )) / Math.pow( 1/ (1+(taux/12)) ,  s*12 - 1 )) / Math.pow( (1+taux) , k )) ; 
//				L.info("crd1+++++++++ =" + crd1) ;
//				//float lxk= tr.findProbaByAgeClient(years+k); 
//				//L.info("lxk+++++++++ =" + lxk) ;
//				tde += (((float) ((float) (((float) (Math.pow((1+(taux/12)) ,  s*12 )) * c.getPrice()) - (float)(Math.pow((1+(taux/12)) ,  s*12 )) / Math.pow( 1/ (1+(taux/12)) ,  s*12 - 1 )) / Math.pow( (1+taux) , k )))* tr.findProbaByAgeClient(years+k)) ; 
//										      }
//			tde = tde /12 ; 
//			ss.setReglemntation(tde);
//			ss.setMotifStatus(SinisterMotif.Réglé);
//			ss.setStatus(sinisterstatus.valide);
//			sinistreRepository.save(ss);
//			try {
//				sendEmailService.sendEmail( u.getEmail() ,  "Sinistre Reglementé",tde , ss.getMotifStatus().toString(),u.getFirstName(),ss.getDateOccurence().toString(), file);
//			} catch (Exception e) {
//				System.out.println("");
//			}	
//			L.info("reg " + ss.getReglemntation()) ;
//			L.info("PRIME+++++++++ =" + tde) ;
//			return tde;
//			
//			
//		}
//	public float CreditSimulator( Long idS, Long idc) {	 
//		sinister s = sinistreRepository.findById(idS).get() ; 
//		User u= s.getUser();
//		double taux =0;
//		Contract  c =cr.findById(idc).get();
//		//Long id=(Long)session.getAttribute("name");	 
//		Calendar calendar = new GregorianCalendar();
//		calendar.setTime(u.getBirthdate());
//		int BDay = calendar.get(Calendar.YEAR);
//		float ss = 0 ;
//		LocalDate now = LocalDate.now();
//		int years = now.getYear()-BDay;
//		if (years < 35 ) // taux 0.00276
//		{ taux =0.00276;
//		 ss= (float) Math.pow((1/1+taux), -years);
//		}
//		else  // tauxt 0.00042
//			{taux=0.00042;
//		 ss= (float) Math.pow((1/1+taux), -years);
//			}
//		double res = (this.TDEMPRUNTEUR(idS) * ss ) / 12  ; 
//		L.info("sinister +++ :" + res) ;
//		float res1 = (float) (this.TDEMPRUNTEUR(idS) + res) ;
//		L.info("wiww +++ :" + res1) ;
//		L.info("WAWAWA +++ :" + u.getSalary()) ;
//		String aa = Float.toString(res1) ; 
//		if(u.getSalary().toString().compareTo(aa) > 0 )
//		{
//			L.info("Vous n'etes pas éligible pour ce type d'emprunt veuillez verifer avec notre administration pour voir nos offres" ) ;
//			return 0 ; 
//		}
//		else {
//		return res1 ;
//		}
//	}
//
//}
//
//	public List<Sinistre> findSinistresByStateReclamation(){
//		List<Sinistre> sinistres= sinistrerepos.findSinistresByStateReclamation();
//		return sinistres;
//	}
//}


