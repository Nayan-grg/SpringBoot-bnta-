package com.nayan.car;

import com.nayan.car.exception.CarNotFoundException;
import com.nayan.car.exception.InvalidRequestException;
import com.nayan.car.exception.RegNumberInvalid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    private CarDAO carDAO;

    public CarService(@Qualifier("postgres") CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public boolean validateRegNumber(String regNumber){
        String space=" ";
        boolean isValid;
        if(space.equals(regNumber.substring(3,4))&&(regNumber.length()==7)){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkIfRegNumberTaken(String regNumber){
        for (Car car : carDAO.selectAllCars()) {
            if(car.getRegNumber().equals(regNumber)){
                return false;
            }
        }return true;
    }

    public void registerNewCar(Car car ){
        //check if the regNumber is in the right format
       if( !validateRegNumber(car.getRegNumber())){
           throw new RegNumberInvalid("RegNumber not valid. Check the format again");
       }
       //check if the reg number is already taken
        if(!checkIfRegNumberTaken(car.getRegNumber())){
            throw new RegNumberInvalid("Reg number already taken");
        }
        //check if the price is less than 0
        if(car.getPrice()<=0){
            throw new InvalidRequestException("Car price cannot be 0 or less");
        }
        int result = carDAO.insertCar(car);

    }

    public List<Car> getCars(){
        if(carDAO.selectAllCars()==null){
            throw new CarNotFoundException("no cars available");
        }
        return carDAO.selectAllCars();
    }

    public Car getCarsById(int id){
        if(carDAO.selectCar(id)==null){
            throw new CarNotFoundException("car not found");
        }else {
        return carDAO.selectCar(id);}
    }
    public void deleteCarById(Integer id){
        if(carDAO.selectCar(id)==null) {
            throw new CarNotFoundException("car with " + id + " not found");
        }
        carDAO.deleteCar(id);

    }
    public void updateCar(Integer carId, Car update){

        //only update car if it exists otherwise throw new exception
        if(carDAO.selectCar(carId)!=null){
            for (Car selectAllCar : carDAO.selectAllCars()) {
                if(selectAllCar.getId()==carId){
                    carDAO.updateCar(carId,update);
                }
            }
        }else{
            throw new CarNotFoundException("car not found");
        }

    }
}
