package com.nayan.car;

import org.springframework.stereotype.Repository;

import java.util.List;

//CarDAO is an interface therefore it does not need any bean
public interface CarDAO {
    int insertCar(Car car);
    int deleteCar(Car car);
    int updateCar(Integer id, Car updatedCar);
    Car selectCar(Integer id);
    List<Car> selectAllCars();

}
