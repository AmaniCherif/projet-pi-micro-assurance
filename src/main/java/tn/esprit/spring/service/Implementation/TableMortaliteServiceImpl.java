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
		 System.out.println("77" );
		 float d_anne = tr.findBySurvivantsLx(ageClient+annee);
		 System.out.println("3" );

		double s = puissance(1/(1+interet), annee);
		 System.out.println("4" );

		p = (float) (capital * s) *  ( d_anne/ d) ;
		 System.out.println("5" );

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
	
	
	private double puissance(double d, int annee) {
		double x1 = d ;
		double x2 = Math.log(( x1) ) ;
		double x3 = x2*annee ;
		double taux = Math.exp((x3));	
		return   taux ;
	}
	
	}