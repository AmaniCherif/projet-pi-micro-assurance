package tn.esprit.spring.service.Implementation;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Car;
import tn.esprit.spring.repository.CarRepository;
import tn.esprit.spring.service.Interface.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	CarRepository carRepo;
	
	public List<Car> getCars() {
		return (List<Car>) carRepo.findAll();
	}

	public Car addCar(Car car) {
		return carRepo.save(car);
	}

	public Car updateCar(Long id, Car newCar) {
		Car modifiedCar = carRepo.findById(id).get();
		modifiedCar.setAge(newCar.getAge());
		modifiedCar.setColor(newCar.getColor());
		modifiedCar.setPrice(newCar.getPrice());
		modifiedCar.setProductionDate(newCar.getProductionDate());
	    return carRepo.save(modifiedCar);
	}

	public void deleteCar(Long id) {
		carRepo.deleteById(id);
	}

	public Car getCar(Long id) {
		return carRepo.findById(id).get();
	}
}
