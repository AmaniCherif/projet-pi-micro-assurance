package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Car;
import tn.esprit.spring.service.Implementation.CarServiceImpl;

@RestController
@RequestMapping("/cars")
public class CarController {
	@Autowired
	CarServiceImpl carServiceImpl;

	@GetMapping("/")
	public List<Car> getCars() {			
		return carServiceImpl.getCars();
	}
	
	@PostMapping("/")
	public Car addCar(@RequestBody Car newCar){
		return carServiceImpl.addCar(newCar);
	}
	
	@DeleteMapping("/{id}")  
	public void deleteCar(@PathVariable("id") Long id) {
		carServiceImpl.deleteCar(id);
	}
	
	@PutMapping("/{id}")
	public Car updateCar(@PathVariable("id") Long id, @RequestBody Car newCar) {
		return carServiceImpl.updateCar(id, newCar);
	}

	@GetMapping("{id}")
	public Car getCar(@PathVariable("id") Long id) {
		return carServiceImpl.getCar(id);
	}
}
