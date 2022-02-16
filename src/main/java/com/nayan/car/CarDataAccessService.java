package com.nayan.car;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class CarDataAccessService implements CarDAO{

    //Because we are using spring, an instance of JDBCTemplate is injected into the heap, so it can be autowired without having to annotate it as a component.
    private JdbcTemplate jdbcTemplate;

    public CarDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertCar(Car car) {
        return 0;
    }

    @Override
    public int deleteCar(Car car) {
        return 0;
    }

    @Override
    public int updateCar(Integer id, Car updatedCar) {
        return 0;
    }

    @Override
    public Car selectCar(Integer id) {
        return null;
    }

    @Override
    public List<Car> selectAllCars() {
        return null;
    }
}
