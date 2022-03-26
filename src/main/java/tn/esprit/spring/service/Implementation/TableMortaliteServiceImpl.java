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
		int k=0;
		float p = 0 ;
		 System.out.println("2" );

		if(sexe.equals(homme)  ){
		// data fil base de donne
			 System.out.println("3" );

		 float d = tr.findBySurvivantsLx(ageClient);
		
		 float d_anne = tr.findBySurvivantsLx(ageClient+annee);
		 

		//double s = puissance(1/(1+interet), annee);
		 double s = Math.pow( 1/ (1+interet) ,annee);
		 
		//hethi normalement tkharajli valeur ghalta ------double s = Math.pow( 1/ (1+interet) ,  k + (1/2)  );
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
		//prime periodique------------------capital differe----------------------------
		public double calculePPCapital_vie(float capital ,float prime ,int age , int annee, double interet , String sexe){
			double somme = 0 ;
			double finale = 0;
			float d = tr.findBySurvivantsLx(age);
			if(sexe.equals(homme)){
				System.out.println("hellllllllllllllllllloooooooooooo");
			float d_n = tr.findBySurvivantsLx(age+annee); // lx a l annee n
			double s_n = puissance(1/(1+interet), annee ); // interet a l annee n : vn
			double t = (d_n/d)*s_n; // l actualisation .. lx+n/lx * vn
			// la somme lx+k/lx * vk jsuqu a n-1
			for ( int i= 0 ; i <(annee-1); i ++ ){	
				float d_anne = tr.findBySurvivantsLx(age+i);
				double s = puissance(1/(1+interet), i);
				System.out.println("----------"+s);
				somme = somme + (d_anne/d)*s; }
			if (capital != 0){ // alors on va calculer la rente	
				 finale = (capital*t)/somme;
				 System.out.println("****** "+"  on a calculé la prime periodique pour n annee "+finale);
					 }
			else {			
				 finale = (prime *somme)/t ;
				 System.out.println("****** "+"  on a calculé le capital obtenu si on donnne une prime periodique pour n annee "+finale);
					}
			}
			else if (sexe.equals(femme)  ){
				float d_n = tr.findBySurvivantsLx(age+annee); // lx a l annee n
				double s_n = puissance(1/(1+interet), annee ); // interet a l annee n : vn
				double t = (d_n/d)*s_n; // l actualisation .. lx+n/lx * vn
				// la somme lx+k/lx * vk jsuqu a n-1
				for ( int i= 0 ; i <(annee-1); i ++ ){	
					float d_anne = tr.findBySurvivantsLx(age+i);
					double s = puissance(1/(1+interet), i);
					System.out.println("----------"+s);
					somme = somme + (d_anne/d)*s; }
				if (capital != 0){ // alors on va calculer la rente	
					 finale = (capital*t)/somme;
					 System.out.println("****** "+"  on a calculé la prime periodique pour n annee "+finale);
						 }
				else {			
					 finale = (prime *somme)/t ;
					 System.out.println("****** "+"  on a calculé le capital obtenu si on donnne une prime periodique pour n annee "+finale);
						}
				
			}
			 System.out.println("****** "+"  on a calculé le capital obtenu si on donnne une prime periodique pour n annee "+finale);

			return finale ;
			
			
		}
		//prime periodique -----------------------------------------------Rente viagere -------------------------------------------------------------------------
		public double calculePPRente( float rente, float prime ,int age , int annee, double interet , String sexe ){// a terme d’avance
			double somme_rente = 0 ;
			double somme_prime = 0 ;
			double finale = 0;
			if(sexe.equals(homme)){
				float d = tr.findBySurvivantsLx(age);

			float d_n = tr.findBySurvivantsLx(age+annee); // lx a l annee n
			double s_n = puissance(1/(1+interet), annee ); // interet a l annee n : vn
			
						// la somme lx+k/lx * vk jsuqu a n-1
						for ( int i= 0 ; i <(annee-1); i ++ ){	
							float d_anne = tr.findBySurvivantsLx(age+i);
							double s = puissance(1/(1+interet), i);
							System.out.println("----------"+s);
							somme_prime = somme_prime + (d_anne/d)*s; }
						
						//  la somme lx+k/lx * vk de n jsuqu a w-x
						for ( int i= annee ; i <(104-age); i ++ ){	
							float d_anne = tr.findBySurvivantsLx(age+i);
							double s = puissance(1/(1+interet), i);
							System.out.println("----------"+s);
							somme_rente = somme_rente + (d_anne/d)*s; }		
			if (rente != 0){ // alors on va calculer la rente	
				 finale = (rente*somme_rente)/somme_prime;
				 System.out.println("****** "+"  on a calculé la prime periodique pour n annee "+finale);	}
			else {			
				 finale = (prime *somme_prime)/somme_rente ;
				 System.out.println("****** "+"  on a calculé les rentes si on donnne une prime periodique pour n annee "+finale);}
			}
			if(sexe.equals(femme)){			
				float d = tr.findBySurvivantsLx(age);
				float d_n = tr.findBySurvivantsLx(age+annee); // lx a l annee n
				double s_n = puissance(1/(1+interet), annee ); // interet a l annee n : vn
				
							// la somme lx+k/lx * vk jsuqu a n-1
							System.out.println("****** za3ma ! !"+ annee);
							for ( int i= 0 ; i <=(annee-1); i ++ ){	
								float d_anne = tr.findBySurvivantsLx(age+i);
								double s = puissance(1/(1+interet), i);
								somme_prime = somme_prime + (d_anne/d)*s;
								System.out.println("****** chfama hne !"+ somme_prime);}
							
							//  la somme lx+k/lx * vk de n jsuqu a w-x
							for ( int i= annee ; i <=(104-age); i ++ ){	
								float d_anne = tr.findBySurvivantsLx(age+i);
								double s = puissance(1/(1+interet), i);
								somme_rente = somme_rente + (d_anne/d)*s;}		
				if (rente != 0){ // alors on va calculer la rente	
					 finale = (rente*somme_rente)/somme_prime;
					 System.out.println("****** "+"  on a calculé la prime periodique pour n annee "+finale);}
				else {	
					System.out.println(prime + " mmmm    " + somme_prime + "   mmmm   "+ somme_rente  );
					 finale = (prime *somme_prime)/somme_rente ;
					 System.out.println("****** "+"  on a calculé les rentes si on donnne une prime periodique pour n annee  .. "+finale); }
				
			}
			return finale ;
			
		}
		
		//prime periodique --------------------------- Vie entiere  -------------------------------------------------------------------------
		public double calculePPVieEntiere(float prime ,float capital ,int age , int annee, double interet , String sexe ){// a terme d’avance
			double somme_capital = 0 ;
			double somme_prime = 0 ;
			double finale = 0;
			if(sexe.equals(homme)){
				float d = tr.findBySurvivantsLx(age);
			double s_n = puissance(1/(1+interet), annee ); // interet a l annee n : vn			
						//  la somme lx+k/lx * vk de n jsuqu a w-x
						for ( int i= 0 ; i <(104-age); i ++ ){	
							float d_anne = tr.findBySurvivantsLx(age+i);
							double s = puissance(1/(1+interet), i);
							System.out.println("----------"+s);
							somme_prime = somme_prime + (d_anne/d)*s; }
										
						for ( int i= 0 ; i <(104-age); i ++ ){	
							float d_anne = tr.findByDecesDx(age+i);
							double s = puissance(1/(1+interet), (i+0.5));
							System.out.println("----------"+s);
							somme_capital = somme_capital + (d_anne/d)*s;}
			
			if (capital != 0){ // alors on va calculer la rente	
				 finale = (capital*somme_capital)/somme_prime;
				 System.out.println("****** "+"  on a calculé la prime periodique pour n annee "+finale);			}
			else {			
				 finale = (prime *somme_prime)/somme_capital ;
				 System.out.println("****** "+"  on a calculé les rentes si on donnne une prime periodique pour n annee "+finale); }
			}
			if(sexe.equals(femme)){
				float d = tr.findBySurvivantsLx(age);
				double s_n = puissance(1/(1+interet), annee ); // interet a l annee n : vn			
							//  la somme lx+k/lx * vk de n jsuqu a w-x
							for ( int i= 0 ; i <(104-age); i ++ ){	
								float d_anne = tr.findBySurvivantsLx(age+i);
								double s = puissance(1/(1+interet), i);
								System.out.println("----------"+s);
								somme_prime = somme_prime + (d_anne/d)*s; }
											
							for ( int i= 0 ; i <(104-age); i ++ ){	
								float d_anne = tr.findByDecesDx(age+i);
								double s = puissance(1/(1+interet), (i+0.5));
								System.out.println("----------"+s);
								somme_capital = somme_capital + (d_anne/d)*s;}
				
				if (capital != 0){ // alors on va calculer la rente	
					 finale = (capital*somme_capital)/somme_prime;
					 System.out.println("****** "+"  on a calculé la prime periodique pour n annee "+finale);				}
				else {			
					 finale = (prime *somme_prime)/somme_capital ;
					 System.out.println("****** "+"  on a calculé les rentes si on donnne une prime periodique pour n annee "+finale); }
			}
			return finale ;
		}
	
	
		
		
		
		
		
	private double puissance(double i, double p) {
		double x1 = i ;
		double x2 = Math.log(( x1) ) ;
		double x3 = x2*p ;
		double taux = Math.exp((x3));	
		return   taux ;
	}
	
	}