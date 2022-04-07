package tn.esprit.spring.repository; //Youyourepo_fraud

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Fraud;

@Repository
public interface IFraudRepo extends JpaRepository<Fraud, Integer>{

}
