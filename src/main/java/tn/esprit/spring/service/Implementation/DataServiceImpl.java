package tn.esprit.spring.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Data;
import tn.esprit.spring.repository.DataRepository;

@Service
public class DataServiceImpl {

	@Autowired
	DataRepository data;
	
	String homme = "homme";
	String femme ="femme";
	//prime unique(capital differe)
	//π = C ∗lx+nlx∗ vn (ouel formule f tableau
	public double calculePUCapital_vieCapital (float capital, int age, int year,double interet,String sexe) {
		double p = 0;
		if (sexe.equals(homme)) {
		Data d = data.findById(age).get();
		Data dyear = data.findById(age+year).get();
		double v = puissance(1/(1+interet), year);
		System.out.println("*"+v);
		p = capital*(dyear.getLxH()/d.getLxH()*v);
		}
		else if (sexe.equals(femme)) {
			Data d = data.findById(age).get();
			Data dyear = data.findById(age+year).get();
			double v = puissance(1/(1+interet), year);
			System.out.println("*"+v);
			p = capital*(dyear.getLxF()/d.getLxF()*v);
			}
		

		
		return p;
	}
	private double puissance(double i, int p) {
		double x = Math.log( (i) );
		double y = x*p;
		double taux = Math.exp(y);
		
		return taux;
	}
	
	
}
