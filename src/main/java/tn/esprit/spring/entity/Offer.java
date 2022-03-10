package tn.esprit.spring.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

public class Offer  {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")

	private Long id; 
	
	@Temporal(TemporalType.DATE)
	private Date date_debut ;
	
	@Temporal(TemporalType.DATE)
	private Date date_fin ;
	
	private String Description ;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTarification() {
		return tarification;
	}

	public void setTarification(double tarification) {
		this.tarification = tarification;
	}

	public State_Offer getState_offers() {
		return state_offers;
	}

	public void setState_offers(State_Offer state_offers) {
		this.state_offers = state_offers;
	}

	private double tarification;
	
	@Enumerated(EnumType.STRING)
	TypeOffer typeOffer ;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	State_Offer state_offers;
	
	@ManyToOne
	private User user; 
	
//getters et Setters 
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
	@OneToOne
	private ContractOffer offer;

}