package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Car;

@Repository
public interface CarRepository  extends CrudRepository<Car, Long>{

}
