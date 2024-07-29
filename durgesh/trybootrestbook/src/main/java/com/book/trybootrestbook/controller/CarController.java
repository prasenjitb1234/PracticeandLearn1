package com.book.trybootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.trybootrestbook.model.Car;
import com.book.trybootrestbook.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/cars")
	public List<Car> getCars(){
		return this.carService.getAllCars();
	}
	
	// get car by id
	
	@GetMapping("/cars/{id}")
	public Car getCar(@PathVariable("id") int id) {
		return carService.getCarById(id);
	}
	
	
	// add car 
	
	@PostMapping("/cars")
	public Car addCar(@RequestBody Car car) {
		Car c = this.carService.addCar(car);
		return c;
	}
	
	
	
	
}
