package tn.esprit.spring.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entity.TableMortalité;
import tn.esprit.spring.repository.TableMortaliteRepository;
import tn.esprit.spring.service.Interface.ITableMortalitéService;


@Service
public class TableMortaliteServiceImpl implements ITableMortalitéService {
	
	@Autowired
	TableMortaliteRepository tr ;

	private static final Logger L= LogManager.getLogger(TableMortaliteServiceImpl.class);
	
	@Override
	public TableMortalité Addtm(TableMortalité t) {
		TableMortalité tm = tr.save(t);
		return tm;
	}
	@Override
	public float findBySurvivantsLx(int ageClient){
		float k  = tr.findBySurvivantsLx(ageClient);
		L.info("tm +++ :" + k) ;
		return k;
		
	}
	@Override
	public float findByDecesDx(int deces){
		float k  = tr.findByDecesDx(deces);
		L.info("tm +++ :" + k) ;
		return k;
		
	}
	
	

	public float findProbaByAgeClient(int ageClient) {
		float k  = tr.findProbaByAgeClient(ageClient);
		L.info("tm +++ :" + k) ;
		return k;
		
	}
	public int findAgeMax(){
		int k = tr.findAgeMax();
		return k;
		
	}

	String homme = "homme";
	String femme = "femme";
	// prime unique ------------------------------------------ Capital differe ----------------------------------------------------------------------	
	public float calculePUCapital_vieCapital(float capital ,int ageClient , int annee, float interet , String sexe){
		float p = 0 ;
		 System.out.println("2" );

		if(sexe.equals(homme)  ){
		// data fil base de donne
			 System.out.println("3" );

		 float d = tr.findBySurvivantsLx(ageClient);
		
		 float d_anne = tr.findBySurvivantsLx(ageClient+annee);
		 

		double s = puissance(1/(1+interet), annee);
		 System.out.println("fffff"+(d_anne/d)*s);

		//p = (float) (capital * (( d_anne/ d)*s ) ;
		p = (float) (capital*(d_anne/d)*s);

		// d_anne.getLxF();
		 System.out.println("======== "+p );
		}
		else if (sexe.equals(femme)  ) {
			 System.out.println("6" );

		 float d = tr.findBySurvivantsLx(ageClient);
		 System.out.println("7" );

		 float d_anne = tr.findBySurvivantsLx(ageClient+annee);
		 System.out.println("8" );

		double s = puissance(1/(1+interet), annee);
		p = (float) (capital * s) *  ( d_anne/ d) ;
		
		// d_anne.getLxF();
		 System.out.println("======== "+p );
			}
		return p;	
		}
	//Prime
	public double calculePUCapital_viePrime(float prime ,int age , int annee, double interet , String sexe){
		double p = 0 ;
		if(sexe.equals(homme)  ){
		float d = tr.findBySurvivantsLx(age);
		float d_anne = tr.findBySurvivantsLx(age+annee);
		double s = puissance(1/(1+interet), annee);
		System.out.println("***"+ s);
		 p = prime/((d_anne/d)*s);
		// d_anne.getLxF();
		 System.out.println("======== "+p );
		}
		else if (sexe.equals(femme)   ){
			float d = tr.findBySurvivantsLx(age);
			float d_anne = tr.findBySurvivantsLx(age+annee);
			double s = puissance(1/(1+interet), annee);
			System.out.println("***"+ s);
			 p = prime/((d_anne/d)*s);
			// d_anne.getLxF();
			 System.out.println("======== "+p );
			}				
		return p;
	}
	// prime unique ------------------------------------------ Rente viagere ----------------------------------------------------------------------	
	public double calculePURenteillimteRente(float rente,int age ,  double interet , String sexe){ // à terme échue)
		double somme = 0 ;
		float d = tr.findBySurvivantsLx(age);
		if(sexe.equals(homme) ){
		for ( int i= 1 ; i <(104-age)+1; i ++ ){	
			float d_anne = tr.findBySurvivantsLx(age+i);
			double s = puissance(1/(1+interet), i);
			
			somme = somme + ((d_anne/d)*s) ;
		}		
		System.out.println("******"+somme*rente);}
		else if (sexe.equals(femme)   ){
			for ( int i= 1 ; i <(104-age)+1; i ++ ){	
				float d_anne = tr.findBySurvivantsLx(age+i);
				double s = puissance(1/(1+interet), i);
				
				somme = somme + ((d_anne/d)*s);
			}		
			System.out.println("******"+somme*rente);}
		
		return somme*rente;
	}
	// prime unique ------------------------------------------ vie entiere  ----------------------------------------------------------------------	

		public double calculePUVieEntiereCapital(float capital,int age ,  double interet ,String sexe){
			double somme = 0 ;
			float d = tr.findBySurvivantsLx(age);
			if(sexe.equals(homme)  ){
			for ( int i= 0 ; i <(104-age); i ++ ){	
				float d_anne = tr.findByDecesDx(age+i);
				double s = puissance(1/(1+interet), (i+0.5));
				System.out.println("----------"+s);
				somme = somme + (d_anne/d)*s;
			}	
			System.out.println("******"+somme*capital);
			}
			else if (sexe.equals(femme)   ){
				for ( int i= 0 ; i <(104-age); i ++ ){	
					float d_anne = tr.findByDecesDx(age+i);
					double s = puissance(1/(1+interet), (i+0.5));
					System.out.println("----------"+s);
					somme = somme + (d_anne/d)*s;
				}	
				System.out.println("******"+somme*capital);
			}
			return somme*capital;
		}
		public double calculePUVieEntierePrime(float prime ,int age ,  double interet ,String sexe){
			double somme = 0 ;
			float d = tr.findBySurvivantsLx(age);
			if(sexe.equals(homme)  ){
			for ( int i= 0 ; i <(104-age); i ++ ){	
				float d_anne = tr.findByDecesDx(age+i);
				double s = puissance(1/(1+interet), (i+0.5));
				System.out.println("----------"+s);
				somme = somme + (d_anne/d)*s;
			}	
			System.out.println("******"+prime/somme);
			}
			else if (sexe.equals(femme)  ){
				for ( int i= 0 ; i <(104-age); i ++ ){	
					float d_anne = tr.findByDecesDx(age+i);
					double s = puissance(1/(1+interet), (i+0.5));
					System.out.println("----------"+s);
					somme = somme + (d_anne/d)*s;
				}	
				System.out.println("******"+prime/somme);
			}
			return prime/somme;
		}
		
		
		
		
		
	private double puissance(double i, double p) {
		double x1 = i ;
		double x2 = Math.log(( x1) ) ;
		double x3 = x2*p ;
		double taux = Math.exp((x3));	
		return   taux ;
	}
	
	}