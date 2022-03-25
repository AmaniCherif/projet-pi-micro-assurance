package tn.esprit.spring.entity; //YosserBenameur

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Rendement implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id; 
	
	private int annee ;
	private double rendement ;
	private double rendementBTA ; //Bon-tresor_assemilable
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public double getRendement() {
		return rendement;
	}
	public void setRendement(double rendement) {
		this.rendement = rendement;
	}
	public double getRendementBTA() {
		return rendementBTA;
	}
	public void setRendementBTA(double rendementBTA) {
		this.rendementBTA = rendementBTA;
	}
	

}
