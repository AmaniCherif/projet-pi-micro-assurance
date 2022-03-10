
package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
public class Investement implements Serializable{
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Double actifId;
	private Double actifs;
	private Double passifs;
	private Double investAmount ; 
	private Long maturite;
	@Temporal(TemporalType.DATE)
	private Date Start_date;
	@Temporal(TemporalType.DATE)
	private Date End_date;
	@Temporal(TemporalType.DATE)
	private Date current_date;
	private Double rachat_amount;
	private Double cumule_amount;
	@Enumerated(EnumType.STRING)
	private Fond fond;
	@Enumerated(EnumType.STRING)
	private Prime_choice prime_choice ;
	
	
	
	
	public Double getActifId() {
		return actifId;
	}




	public void setActifId(Double actifId) {
		this.actifId = actifId;
	}




	public Double getActifs() {
		return actifs;
	}




	public void setActifs(Double actifs) {
		this.actifs = actifs;
	}




	public Double getPassifs() {
		return passifs;
	}




	public void setPassifs(Double passifs) {
		this.passifs = passifs;
	}




	public Double getInvestAmount() {
		return investAmount;
	}




	public void setInvestAmount(Double investAmount) {
		this.investAmount = investAmount;
	}




	public Long getMaturite() {
		return maturite;
	}




	public void setMaturite(Long maturite) {
		this.maturite = maturite;
	}




	public Date getStart_date() {
		return Start_date;
	}




	public void setStart_date(Date start_date) {
		Start_date = start_date;
	}




	public Date getEnd_date() {
		return End_date;
	}




	public void setEnd_date(Date end_date) {
		End_date = end_date;
	}




	public Date getCurrent_date() {
		return current_date;
	}




	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}




	public Double getRachat_amount() {
		return rachat_amount;
	}




	public void setRachat_amount(Double rachat_amount) {
		this.rachat_amount = rachat_amount;
	}




	public Double getCumule_amount() {
		return cumule_amount;
	}




	public void setCumule_amount(Double cumule_amount) {
		this.cumule_amount = cumule_amount;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	@ManyToOne
	private User user;
	
	
}

