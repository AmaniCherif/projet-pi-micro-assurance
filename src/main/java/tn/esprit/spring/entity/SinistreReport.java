package tn.esprit.spring.entity;

import javax.persistence.ManyToOne;

public class SinistreReport {
@ManyToOne
private Contract contract;
}
