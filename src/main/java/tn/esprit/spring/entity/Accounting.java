package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Accounting implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountingId;
	
	public int getAccountingId() {
		return accountingId;
	}
	public void setAccountingId(int accountingId) {
		this.accountingId = accountingId;
	}
	private int year;
	//actifs
	private float assets; //la somme des actifs
	//passifs
	private float liabilities;//la somme des passifs
	//placement
	private float placement;
	//par  des reassureurs
	private float reinsurersShare;
	//autres creances
	private float receivables;
	//capitaux propres
	private float equity;
	//provisions techniques
	private float technicalProvisions;
	//autres dettes
	private float otherDebts;
	//resultat de l'exercise
	@Column(name="exercise_result")
	private float exerciseResult;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getAssets() {
		return assets;
	}
	public void setAssets(float assets) {
		this.assets = assets;
	}
	public float getLiabilities() {
		return liabilities;
	}
	public void setLiabilities(float liabilities) {
		this.liabilities = liabilities;
	}
	public float getPlacement() {
		return placement;
	}
	public void setPlacement(float placement) {
		this.placement = placement;
	}
	public float getReinsurersShare() {
		return reinsurersShare;
	}
	public void setReinsurersShare(float reinsurersShare) {
		this.reinsurersShare = reinsurersShare;
	}
	public float getReceivables() {
		return receivables;
	}
	public void setReceivables(float receivables) {
		this.receivables = receivables;
	}
	public float getEquity() {
		return equity;
	}
	public void setEquity(float equity) {
		this.equity = equity;
	}
	public float getTechnicalProvisions() {
		return technicalProvisions;
	}
	public void setTechnicalProvisions(float technicalProvisions) {
		this.technicalProvisions = technicalProvisions;
	}
	public float getOtherDebts() {
		return otherDebts;
	}
	public void setOtherDebts(float otherDebts) {
		this.otherDebts = otherDebts;
	}
	public float getExerciseResult() {
		return exerciseResult;
	}
	public void setExerciseResult(float exerciseResult) {
		this.exerciseResult = exerciseResult;
	}
	@OneToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
