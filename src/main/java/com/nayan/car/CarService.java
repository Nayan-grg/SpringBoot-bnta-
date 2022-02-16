package com.nayan.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class CarService {

    private CarDAO carDAO;

    public CarService(@Qualifier("fake") CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void registerNewCar(Car car ){
        //Business Logic: Check if reg number is valid and not take
        if(car.getPrice()<=0){
            throw new IllegalStateException("Car price cannot be 0 or less");
        }
        int result = carDAO.insertCar(car);
        if(result!=1){
            throw new IllegalStateException("Could not save car");
        }
    }

    public List<Car> getCars(){
        return carDAO.selectAllCars();
    }

    public Car getCarsById(int id){
        return carDAO.selectCar(id);
    }
    public void deleteCarById(int id){
        for (Car selectAllCar : carDAO.selectAllCars()) {
            if(selectAllCar.getId()==id){
                carDAO.deleteCar(selectAllCar);
            }
        }
    }
    public void updateCar(Integer carId, Car update){
        for (Car selectAllCar : carDAO.selectAllCars()) {
            if(selectAllCar.getId()==carId){
                carDAO.updateCar(carId,update);
            }
        }
    }
}
