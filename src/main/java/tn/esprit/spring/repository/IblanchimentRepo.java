package tn.esprit.spring.repository; //Youyourepo_blanchiment

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Blanchiment;

@Repository
public interface IblanchimentRepo extends JpaRepository<Blanchiment, Integer>{

}
