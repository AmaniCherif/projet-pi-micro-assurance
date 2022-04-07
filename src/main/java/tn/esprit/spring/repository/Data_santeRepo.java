package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Datasante;


@Repository
public interface Data_santeRepo  extends JpaRepository<Datasante, Integer>{

}
