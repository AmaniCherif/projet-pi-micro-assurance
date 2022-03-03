package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Sinistre")
public class Sinistre implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column (name= "id_Sinistre")
	private long Id_Sinistre;
	@Temporal(TemporalType.DATE)
	private Date Date_Declaration;
	private String Type_Sinistre;
	private String Place_Sinistre;
	private String State_Sinistre;
	
	
	public long getId_Sinistre() {
		return Id_Sinistre;
	}
	public void setId_Sinistre(long id_Sinistre) {
		Id_Sinistre = id_Sinistre;
	}
	public Date getDate_Declaration() {
		return Date_Declaration;
	}
	public void setDate_Declaration(Date date_Declaration) {
		Date_Declaration = date_Declaration;
	}
	public String getType_Sinistre() {
		return Type_Sinistre;
	}
	public void setType_Sinistre(String type_Sinistre) {
		Type_Sinistre = type_Sinistre;
	}
	public String getPlace_Sinistre() {
		return Place_Sinistre;
	}
	public void setPlace_Sinistre(String place_Sinistre) {
		Place_Sinistre = place_Sinistre;
	}
	public String getState_Sinistre() {
		return State_Sinistre;
	}
	public void setState_Sinistre(String state_Sinistre) {
		State_Sinistre = state_Sinistre;
	}
	
	@ManyToOne
	private User user;
}
