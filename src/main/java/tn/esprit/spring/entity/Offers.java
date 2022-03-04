package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table( name = "Offers")
public class Offers implements Serializable {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	 @Column( name = "id_Offer")
	private int IdOffer; 
	
	@Temporal(TemporalType.DATE)
	private Date date_debut ;
	
	@Temporal(TemporalType.DATE)
	private Date date_fin ;
	
	private String Description ;
	
	
	@Enumerated(EnumType.STRING)
	State_Offers type_offers;
	
	
	
//getters et Setters 
	public int getIdOffer() {
		return IdOffer;
	}

	public void setIdOffer(int idOffer) {
		IdOffer = idOffer;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public State_Offers getType_offers() {
		return type_offers;
	}

	public void setType_offers(State_Offers type_offers) {
		this.type_offers = type_offers;
	}
@ManyToOne
private User user;
}
