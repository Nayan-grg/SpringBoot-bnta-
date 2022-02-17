package com.nayan.car;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class CarDataAccessService implements CarDAO{

    //Because we are using spring, an instance of JDBCTemplate is injected into the heap,
    // so it can be autowired without having to annotate it as a component.
    private JdbcTemplate jdbcTemplate;

    public CarDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCar(Car car) {
        String insertSql = """
                    INSERT INTO car(brand, regNumber,price) 
                    VALUES(?, ?,?)
                    """;
        int rowsAffected= jdbcTemplate.update(
                insertSql,
                String.valueOf(car.getBrand()),
                car.getRegNumber(),
                car.getPrice());
        return rowsAffected;
    }

    @Override
    public int deleteCar(Integer id) {
        String sql="DELETE FROM car WHERE id=?";
        int rowsAffected=jdbcTemplate.update(sql,id);
        return rowsAffected;
    }



    @Override
    public Car selectCar(Integer id) {
        Car car;
        try {
            String sql = "SELECT * FROM car WHERE id =? ";
            car = jdbcTemplate.queryForObject(sql, new RowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return car;
    }


    @Override
    public List<Car> selectAllCars() {
        //Don't use * in SQL
        String insertSql = """
                            SELECT id,regNumber,brand,price 
                            FROM car
                            """;
//        List<Map<String, Object>> rows=jdbcTemplate.queryForList(insertSql);
        List<Car> cars= jdbcTemplate.query(insertSql,new RowMapper());
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
