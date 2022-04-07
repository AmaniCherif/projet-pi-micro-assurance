package tn.esprit.spring.entity; //actif_financier_yosser_benameur

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
public class ActifFinancier implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)

	private Long id ;
	
	@Temporal(TemporalType.DATE)
	private Date date_debut ; //wa9teh_yebda_contrat_investissement_mte3i
	
	@Temporal(TemporalType.DATE) //wa9teh_youfa_contrat_investissement
	private Date date_fin ;
	
	private int maturite ; //duree_mta3_contrat
	
	private float montant_investi ; //9adeh_flous_bech_tinvesti
	
	private float montant_cumule ; //9adeh_mkadsa_3andek_flous_hhh
	
	private float montant_rachat ; //ki_t7eb_tejbed_flous_meli_investitou
	
	private int accepte_rachat ;
	
	private Date date_actuel ;
	
	@Enumerated(EnumType.STRING)
	 private Prime choixPrime ;
	
	@Enumerated(EnumType.STRING)
	private Fond nomFond ;
	
	private String etat ; // resiliation_ou_encours

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getMaturite() {
		return maturite;
	}

	public void setMaturite(int maturite) {
		this.maturite = maturite;
	}

	public float getMontant_investi() {
		return montant_investi;
	}

	public void setMontant_investi(float montant_investi) {
		this.montant_investi = montant_investi;
	}

	public float getMontant_cumule() {
		return montant_cumule;
	}

	public void setMontant_cumule(float montant_cumule) {
		this.montant_cumule = montant_cumule;
	}

	public float getMontant_rachat() {
		return montant_rachat;
	}

	public void setMontant_rachat(float montant_rachat) {
		this.montant_rachat = montant_rachat;
	}

	public int getAccepte_rachat() {
		return accepte_rachat;
	}

	public void setAccepte_rachat(int accepte_rachat) {
		this.accepte_rachat = accepte_rachat;
	}

	public Date getDate_actuel() {
		return date_actuel;
	}

	public void setDate_actuel(Date date_actuel) {
		this.date_actuel = date_actuel;
	}

	public Prime getChoixPrime() {
		return choixPrime;
	}

	public void setChoixPrime(Prime choixPrime) {
		this.choixPrime = choixPrime;
	}

	public Fond getNomFond() {
		return nomFond;
	}

	public void setNomFond(Fond nomFond) {
		this.nomFond = nomFond;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	@ManyToOne
	 private User userActif;

	public User getUserActif() {   
		return userActif;
	}

	public void setUserActif(User userActif) { 
		this.userActif = userActif;
	} 

	
}
