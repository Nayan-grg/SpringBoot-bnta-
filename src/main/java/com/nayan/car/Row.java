package com.nayan.car;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Row implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car=new Car();
        car.setId(rs.getInt("id"));
        car.setBrand(Brand.valueOf(rs.getString("brand")));
        car.setPrice(rs.getDouble("price"));
        car.setRegNumber(rs.getString("regNumber"));
        return car;
    }

}


