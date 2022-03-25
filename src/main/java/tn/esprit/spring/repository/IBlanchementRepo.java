package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Blanchiment;

@Repository
public interface IBlanchementRepo extends JpaRepository<Blanchiment, Integer>{

}
