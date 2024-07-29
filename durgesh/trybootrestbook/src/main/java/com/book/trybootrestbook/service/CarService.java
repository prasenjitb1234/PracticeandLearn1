package com.book.trybootrestbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.book.trybootrestbook.model.Car;

@Service
public class CarService {

	
	private static  List<Car> list = new ArrayList<>();
	
	static {
		list.add(new Car(1,"Tata","Nexon"));
		list.add(new Car(2,"Tata","Nano"));
		list.add(new Car(3,"Audi","R8"));
	}
	
	// get all cars 
	
	public List<Car> getAllCars(){
		return list;
	}
	
	// get car by id 
	
	public Car getCarById(int id) {
		Car car = null; 
		
		for(Car currentCar : list) {
			if(currentCar.getId()==id) {
				car = currentCar;
				break;
			}
		}
		return car;
	}
	
	
	// add car new 
	
	public Car addCar(Car c) {
		list.add(c);
		return c;
	}
	
	
}
