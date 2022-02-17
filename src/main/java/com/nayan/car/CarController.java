package com.nayan.car;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getCars();
    }
    @PostMapping
    public void addCar(@Valid @RequestBody Car car){
        carService.registerNewCar(car);
    }

    @GetMapping(path = "/{id}")
    public Car getCarById(@PathVariable("id") Integer carId) {
        return carService.getCarsById(carId);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCarById(@PathVariable("id") Integer carId) {
        carService.deleteCarById(carId);
    }


    @PutMapping(path = "/{id}")
    public void updateCar(@PathVariable("id") Integer carId, @RequestBody Car update) {
        carService.updateCar(carId,update);
    }
}
