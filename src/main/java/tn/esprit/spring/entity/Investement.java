/*package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="investments")
public class Investement implements Serializable{
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Actif_Id;
	private Long Actifs;
	private Long Passifs;
	private Long Invest_amount ; 
	private int Maturite;
	@Temporal(TemporalType.DATE)
	private Date Start_date;
	@Temporal(TemporalType.DATE)
	private Date End_date;
	@Temporal(TemporalType.DATE)
	private Date Current_date;
	
	private Double rachat_amount;
	private Double cumule_amount;
	@Enumerated(EnumType.STRING)
	private Fond fond;
	@Enumerated(EnumType.STRING)
	private Prime_choice prime_choice ;
	

	public Double getActif_Id() {
		return Actif_Id;
	}
	public void setActif_Id(Double actif_Id) {
		Actif_Id = actif_Id;
	}
	public Double getActifs() {
		return Actifs;
	}
	public void setActifs(Double actifs) {
		Actifs = actifs;
	}
	public Double getPassifs() {
		return Passifs;
	}
	public void setPassifs(Double passifs) {
		Passifs = passifs;
	}
	public Double getInvest_amount() {
		return Invest_amount;
	}
	public void setInvest_amount(Double invest_amount) {
		Invest_amount = invest_amount;
	}
	public Integer getMaturite() {
		return Maturite;
	}
	public void setMaturite(Integer maturite) {
		Maturite = maturite;
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
		return Current_date;
	}
	public void setCurrent_date(Date current_date) {
		Current_date = current_date;
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
	
	@ManyToOne
	private User user;
	
	
}
*/