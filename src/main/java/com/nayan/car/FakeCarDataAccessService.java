package com.nayan.car;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fake")
public class FakeCarDataAccessService implements CarDAO{

    private List<Car> cars;
    public FakeCarDataAccessService(List<Car> cars) {
//        this.cars = cars;  -> This doesn't create an instance of cars
        this.cars=new ArrayList<>(); //This creates an instance of cars
    }

    @Override
    public int insertCar(Car car) {
        cars.add(car);
        return 1;
    }

    @Override
    public int deleteCar(Integer id) {
        for (Car car1 : cars) {
            if(id==car1.getId()){
                cars.remove(id);
                return 1;
            }

        }
        return 0;
    }


    @Override
    public int updateCar(Integer id, Car updatedCar) {
        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getId()==updatedCar.getId()) {
                cars.set(i,updatedCar);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Car selectCar(Integer id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }
    @Override
    public List<Car> selectAllCars() {
        return cars;
    }
}
