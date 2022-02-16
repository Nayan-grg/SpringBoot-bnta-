package com.nayan.car;

import com.nayan.HelloSpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //This is used to create an instance of the CarController class so this can also be found in the heap
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping(path = "cars")
    public void addCar(@RequestBody Car car){
        carService.registerNewCar(car);
    }

    @GetMapping(path="cars")
    public List<Car> getCars(){
        return carService.getCars();
    }


    //Complete this and then complete it also on the Service and the DAO against the fakeDAO and not the realDAO and test it using PostMan.

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
