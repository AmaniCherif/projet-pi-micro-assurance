package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.Car;
import tn.esprit.spring.entity.Claims;

public interface CarService {
	
	List<Car> getCars();
	
	Car addCar(Car car);
	
	void deleteCar(Long id);
	
	Car updateCar(Long id, Car car);
	
	Car getCar(Long id);
}
