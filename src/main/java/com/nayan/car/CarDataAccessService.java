package com.nayan.car;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("postgres")
public class CarDataAccessService implements CarDAO{

    //Because we are using spring, an instance of JDBCTemplate is injected into the heap, so it can be autowired without having to annotate it as a component.
    private JdbcTemplate jdbcTemplate;

    public CarDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCar(Car car) {
        String insertSql = """
    INSERT INTO car(brand, regNumber,price) VALUES(?, ?,?)
    """;
        return jdbcTemplate.update(insertSql,String.valueOf(car.getBrand()),car.getRegNumber(),car.getPrice());
    }

    @Override
    public int deleteCar(Car car) {
        String sql="DELETE FROM car WHERE id=?";
        return jdbcTemplate.update(sql,car.getId());

    }


    @Override
    public Car selectCar(Integer id) {
        String sql= "SELECT * FROM car WHERE id =? ";
        return jdbcTemplate.queryForObject(sql,new Row(),id);
    }



    @Override
    public List<Car> selectAllCars() {
        String insertSql = """
                            SELECT * FROM car
                            """;
//        List<Map<String, Object>> rows=jdbcTemplate.queryForList(insertSql);
        List<Car> cars= jdbcTemplate.query(insertSql,new Row());
        return cars;

    }

    @Override
    public int updateCar(Integer id, Car updatedCar) {
        String SQL = "UPDATE car "
                + "SET brand = ?, "
                +"regNumber=?,"
                +"price =?"
                + "WHERE id = ?";
        return jdbcTemplate.update(SQL,String.valueOf(updatedCar.getBrand()),updatedCar.getRegNumber(),updatedCar.getPrice(),id);

    }
}
