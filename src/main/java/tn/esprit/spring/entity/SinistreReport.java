package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class SinistreReport {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int sinistreReport;
@ManyToOne
private Contract contract;
}
