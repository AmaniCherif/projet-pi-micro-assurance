package tn.esprit.spring.entity; //YosserBenameur

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blanchiment implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private int id ; 
	
	private String cause ;
	private int niveau ;
	private String valide ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public String getValide() {
		return valide;
	}
	public void setValide(String valide) {
		this.valide = valide;
	}

	
	
}
