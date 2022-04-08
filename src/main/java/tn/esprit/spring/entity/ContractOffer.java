package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class ContractOffer implements Serializable{

	private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Contract_Offers")
    private int idContractOffer;
    
	@Enumerated(EnumType.STRING)
    private State_Offer state_offers;
    private String date_debut;
    private String date_fin;
    private double Tarification;
    private float vie_mixte;
    private float deces_mixte;
    private int duree;

    public int getIdContractOffer() {
		return idContractOffer;
	}
	public void setIdContractOffer(int idContractOffer) {
		this.idContractOffer = idContractOffer;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public double getTarification() {
		return Tarification;
	}
	public void setTarification(double tarification) {
		Tarification = tarification;
	}
	public float getVie_mixte() {
		return vie_mixte;
	}
	public void setVie_mixte(float vie_mixte) {
		this.vie_mixte = vie_mixte;
	}

	public float getDeces_mixte() {
		return deces_mixte;
	}
	public void setDeces_mixte(float deces_mixte) {
		this.deces_mixte = deces_mixte;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public State_Offer getState_offers() {
		return state_offers;
	}
	public void setState_offers(State_Offer state_offers) {
		this.state_offers = state_offers;
	}
	 



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



    @JsonManagedReference
	@OneToOne(mappedBy="offer")
	private Offer offer;

    @JsonBackReference
    @ManyToOne
	private User user;
    
}