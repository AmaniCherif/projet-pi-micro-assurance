package tn.esprit.spring.entity;

import java.util.Date;



import javax.persistence.CascadeType;

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
public class ContractOffer {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int contOffId ;
	private int duration ;
	private double deathMixte;
	private double lifeMixte;
	private double tarification;
	@Temporal(TemporalType.DATE)
	private Date endingDate ;
	@Temporal(TemporalType.DATE)
	private Date startingDate ;
	@Enumerated(EnumType.STRING)
	State_Offer state_offers;
	public int getContOffId() {
		return contOffId;
	}
	public void setContOffId(int contOffId) {
		this.contOffId = contOffId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getDeathMixte() {
		return deathMixte;
	}
	public void setDeathMixte(double deathMixte) {
		this.deathMixte = deathMixte;
	}
	public double getTarification() {
		return tarification;
	}
	public void setTarification(double tarification) {
		this.tarification = tarification;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	@OneToOne(mappedBy="offer")
	private Offer offer;

	@OneToOne(mappedBy="contOff")
	private Offer offers;

	
	@ManyToOne
	private User user;
}
