package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.OneToOne;

public class Provisions implements Serializable{

	private int id_provision;
	private String type;
	private String descreption;
	private double price;
	
	@OneToOne(mappedBy = "provisions")
	private Sinistre sinistre;

	public int getId_provision() {
		return id_provision;
	}

	public void setId_provision(int id_provision) {
		this.id_provision = id_provision;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Sinistre getSinistre() {
		return sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}
	
}
