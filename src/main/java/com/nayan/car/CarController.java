package com.nayan.car;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path="cars")
    public List<Car> getAllCars(){
        return carService.getCars();
    }
    @PostMapping(path = "cars")
    public void addCar(@RequestBody Car car){
        carService.registerNewCar(car);
    }

    @GetMapping(path = "cars/{id}")
    public Car getCarById(@PathVariable("id") Integer carId) {
        return carService.getCarsById(carId);
    }

    @DeleteMapping(path = "cars/{id}")
    public void deleteCarById(@PathVariable("id") Integer carId) {
        carService.deleteCarById(carId);
    }


    @PutMapping(path = "cars/{id}")
    public void updateCar(@PathVariable("id") Integer carId, @RequestBody Car update) {
        carService.updateCar(carId,update);
    }
}
