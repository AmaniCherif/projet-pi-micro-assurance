package tn.esprit.spring.service.Implementation; //yosserBenameur

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DataFondEURO;
import tn.esprit.spring.entity.Rendement;
import tn.esprit.spring.repository.IActifFinancier;
import tn.esprit.spring.repository.IDataFondEURORepo;
import tn.esprit.spring.repository.IRendement;


@Service
public class DataFondEuroService {
	
	@Autowired
	IDataFondEURORepo dataEuro ;
	@Autowired
	IRendement rendement ;
	

    @Autowired
    IActifFinancier actifFinancierRepo ;
    
    public void addDataEuro(DataFondEURO d) {
		float prixAchat = d.getMontantSouscription()*d.getRemunerationPrincipale();
		float tauxrendement =( d.getTauxCoupon()*d.getMontantSouscription())/prixAchat;			
		int echeanceYear = d.getDateSouscription().getYear() + d.getMaturite();
		int echeancedd = d.getDateSouscription().getDay() ;
		int echeancemm = d.getDateSouscription().getMonth();
		d.setDateEcheance(new Date(echeanceYear,echeancemm,echeancedd));
		d.setTauxRendement(tauxrendement);	
		d.setPrixAchat(prixAchat);
		dataEuro.save(d);	
		calculerendementTotal(); 
	}

    public List<DataFondEURO> listeBTA(){	
		return dataEuro.findByTypBonde("BTA") ;
	}
	public List<DataFondEURO> listeAll(){	
		return dataEuro.findAll();
	}
	public void deleteFondEURO( int id){
		dataEuro.deleteById(id);
		calculerendementTotal();
			}
	
	
	public List<Rendement> listeRendementPortefeuille(){	
		return (List<Rendement>)rendement.findAll();
	}
	
	public void calculeprofitUnique(){ // kol 3am na3tik rendement eli na3mlou ena .. w ken a9al min 0.15 nzidek ena 0.015 ... etheka l min 
		float primeUnique = 1000 ;
		int dureeContrat = 5 ;
		double frais_gestion = 0.03 ;
		double primerelle  =primeUnique - primeUnique*frais_gestion;
		double f ;
		float rachat ;
		//int year = 2021 ; 
		for (int i = 0 ; i < dureeContrat ; i++){
			System.out.println("hayaaaaaaaaa ezreb");
			Rendement r = rendement.findByAnnee(2021+i);
			System.out.println("barrrraaa aaaaadddddd");
			double t = r.getRendement();
			
			System.out.println("************-------*-----------***********" + t);
			double m = t*0.85 ;//*****
			System.out.println("nchallaah lyoum temchy");
			//double pb = m - frais_gestion; //participation_bénéfice
			if (m < 0.015 ){
				rachat = (float) primerelle ; // rachat
				System.out.println("---------" + rachat );

				primerelle = 	primerelle+(float) (primerelle*0.015) ;					
				primerelle = primerelle - primerelle*frais_gestion;
				System.out.println(" negative : "+primerelle);
				double rachat_totale =   primerelle - (primerelle - rachat )*0.8  ;
				System.out.println("---------" + rachat_totale );
				}
			else {
				rachat = (float) primerelle ; // rachat
				System.out.println("---------" + rachat );

				primerelle = primerelle +	(float) (primerelle*m) ;
				primerelle = primerelle - primerelle*frais_gestion;
				System.out.println("positive  : "+primerelle);
				double rachat_totale =   primerelle - (primerelle - rachat )*0.8  ;
				System.out.println("---------" + rachat_totale );
				}				
			}			
	}
	
     //assurance ki t'investi_7atet_1000dinars_da5let_1100 rb7et 10%
	//ken negatif ta3tik 70% mel diff
	public void calculeprofitPeriodique(){
		float primePeriodiquePrincipale = 1000 ;
		int dureeContrat = 5 ;
		double frais_gestion = 0.03 ;
		float	primePeriodique  =(float) (primePeriodiquePrincipale - primePeriodiquePrincipale*frais_gestion);
		float rachat ;
		int year = 2021 ; 
		for (int i = 0 ; i < dureeContrat ; i++){
			Rendement r = rendement.findByAnnee(year+i);
			
			double t = r.getRendement();
			
			//double m=(r.getRendement())*0.85;
			System.out.println("tokhrej wallaaaaaa");
			double m = t*0.85 ; //te5ou_rendement_mta3_3am
			//double pb = m - frais_gestion; pparticipation bénéfice loi assurance
			//ficas_hethy_assurance_5assra_bech_ta3tik_ken_taux_minimum_garentis
			if (m < 0.015 ){
				
				rachat = primePeriodique ; // rachat
				System.out.println("rachat  : " + rachat);
				
				primePeriodique = primePeriodiquePrincipale +	primePeriodique+(float) (primePeriodique*0.015) ;					
				primePeriodique = (float) (primePeriodique - primePeriodique*frais_gestion);
				System.out.println(" negative : "+primePeriodique);
				double ry =   primePeriodique - (primePeriodique - rachat - primePeriodiquePrincipale)*0.8  ;
				System.out.println("---------" + ry );
				}
			else {
				
				rachat = primePeriodique ; // rachat
				System.out.println("rachat  : " + rachat);
				primePeriodique =primePeriodiquePrincipale+ primePeriodique +	(float) (primePeriodique*m) ;
				primePeriodique = (float) (primePeriodique - primePeriodique*frais_gestion);
				System.out.println("positive  : "+primePeriodique);
				double ry =  primePeriodique -(primePeriodique - rachat - primePeriodiquePrincipale)*0.8  ;
				System.out.println("---------" + ry );					}						
	}	
	}
	
	public float rendementPortefeuilleEUROcroissance(){
		float s = 0 ;
		float f = 0 ;
		Date dd  = new Date();
		List<DataFondEURO> bonds = dataEuro.findByTypBondeAndDateSouscriptionLessThanEqualAndDateEcheanceGreaterThanEqual("BTA" , dd , dd);
		//List<DataFondEURO> bonds = dataEuro.findByTypBonde("BTA");
		for (DataFondEURO bond: bonds){
			s = s + bond.getMontantSouscription() ;	
		}
		
		System.out.println("----------"+ s );
		for (DataFondEURO bond: bonds){
			f = f + (bond.getTauxRendement()*bond.getMontantSouscription())/s ;
			System.out.println("----------"+ bond.getId() );
		}
		System.out.println("----------"+ f );
		
		// f * 0.85 mil benefices lkol
		return f ;
	}
	
	public void liste(){
		for ( int i = 2021 ; i < 2027 ; i++ ){
		List<DataFondEURO> ls = 	dataEuro.listeParAnneeBTA(i);
			for ( DataFondEURO l : ls ){
				System.out.println("-----"+ l.getDateSouscription()+ "-------"+ l.getDateEcheance() + "year : " + i);
			}
		
		}
	}
	
	public void calculerendementTotal(){
		rendement.deleteAll();
		int currentYear = 0 ; //echeance	
		int s = 0 ;
		int m = 0 ;
		List<DataFondEURO> ls = 	dataEuro.findAllByOrderByDateEcheanceAsc();
		for(DataFondEURO l : ls){ currentYear= l.getDateEcheance().getYear();			 m=currentYear+1900;  }
		List<DataFondEURO> ls2 = 	dataEuro.findAllByOrderByDateSouscriptionDesc();
		for(DataFondEURO l : ls2){ currentYear= l.getDateSouscription().getYear(); 
		System.out.println("----------------------------" + l.getDateSouscription() + "------" + l.getDateEcheance());
		 s=currentYear+1900; 
		}
		for(int i = s ; i <= m ; i++){
			Date d = new Date();
			d.setMonth(0);
			d.setDate(1);
			d.setYear(i);
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////  Rendement portefeuille   /////////////////////////////////////////////////
			List<DataFondEURO> liste = 	dataEuro.listeParAnnee(i);
			float somme_montant = 0 ;
			float f = 0 ;
			List<DataFondEURO> l = new ArrayList<DataFondEURO>();
			for ( DataFondEURO all : liste ){      l.add(all);      	}
			for (DataFondEURO all: l){		somme_montant = somme_montant + all.getMontantSouscription() ;		}
			for (DataFondEURO all : l){
				if ((all.getDateSouscription().getYear()+1900) == d.getYear() ){
					System.out.println("annnnnnnneeee " + (all.getDateSouscription().getYear()+1900) );
					float taux = 0 ;
					long t  = 0 ;
					t = 12 - all.getDateSouscription().getMonth();	
					double x1 = 1+ all.getTauxRendement() ;
					double x2 = Math.log(( x1) ) ;
					double x3 = x2*t/12 ;
					taux = (float) Math.exp((x3))-1;	
					f = f + (taux*all.getMontantSouscription())/somme_montant ;	
				
					System.out.println("xxxxx1111 : " + x1 + "   xxxxxxx2222222 : "+ x2 + "     xxxxxxx3333 : " + x3);
					System.out.println("daaaate" +all.getDateEcheance().getYear() );
					System.out.println("tttttt" +t );
					System.out.println("taux" +taux );
					System.out.println("fffffffffffff" +f );
				}
				else if((all.getDateEcheance().getYear()+1900) == d.getYear()) {
					float taux = 0 ;
					long t  = 0 ;
					t =  all.getDateEcheance().getMonth() - d.getMonth();	
					double x1 = 1+ all.getTauxRendement() ;
					double x2 = Math.log(( x1) ) ;
					double x3 = x2*t/12 ;
					taux = (float) Math.exp((x3))-1;	
					f = f + (taux*all.getMontantSouscription())/somme_montant ;						
				}
				else{
					f = f + (all.getTauxRendement()*all.getMontantSouscription())/somme_montant ;									
				}					}				
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////  Rendement portefeuille BTA  /////////////////////////////////////////////////				
			List<DataFondEURO> listeBTA = 	dataEuro.listeParAnneeBTA(i);
			float somme_montantBTA = 0 ;
			float fBTA = 0 ;
			List<DataFondEURO> lBTA = new ArrayList<DataFondEURO>();
			for ( DataFondEURO all : listeBTA ){      lBTA.add(all);      	}

			for (DataFondEURO all: lBTA){		somme_montantBTA = somme_montantBTA + all.getMontantSouscription() ;		}
			for (DataFondEURO all : lBTA){
				if ((all.getDateSouscription().getYear()+1900) == d.getYear() ){
					System.out.println("annnnnnnneeee " + (all.getDateSouscription().getYear()+1900) );
					float taux = 0 ;
					long t  = 0 ;
					t = 12 - all.getDateSouscription().getMonth();	
					double x1 = 1+ all.getTauxRendement() ;
					double x2 = Math.log(( x1) ) ;
					double x3 = x2*t/12 ;
					taux = (float) Math.exp((x3))-1;	
					fBTA = fBTA + (taux*all.getMontantSouscription())/somme_montantBTA ;	
				
					System.out.println("xxxxx1111 : " + x1 + "   xxxxxxx2222222 : "+ x2 + "     xxxxxxx3333 : " + x3);
					System.out.println("daaaate" +all.getDateEcheance().getYear() );
					System.out.println("tttttt" +t );
					System.out.println("taux" +taux );
					System.out.println("fffffffffffff" +fBTA );
				}
				else if((all.getDateEcheance().getYear()+1900) == d.getYear()) {
					float taux = 0 ;
					long t  = 0 ;
					t =  all.getDateEcheance().getMonth() - d.getMonth();	
					double x1 = 1+ all.getTauxRendement() ;
					double x2 = Math.log(( x1) ) ;
					double x3 = x2*t/12 ;
					taux = (float) Math.exp((x3))-1;	
					fBTA = fBTA + (taux*all.getMontantSouscription())/somme_montantBTA ;						
				}
				else{
					fBTA = fBTA + (all.getTauxRendement()*all.getMontantSouscription())/somme_montantBTA ;									
				}		
			}
			
			System.out.println("iiiiiiiiiiiiiiiiii" + i);
			Rendement r = new Rendement();

			r.setAnnee(i);
			r.setRendement(f);
			r.setRendementBTA(fBTA);
			rendement.save(r); 
			}
		}
	
	public static double puissance(double a, double p){
        double result = 1;        
        for(int i = 0; i < p; i++) {
            result = result * a;
        }	         
        return(result);
    }
 
	
	
}
