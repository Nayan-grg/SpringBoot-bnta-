package com.nayan.car;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Car {
    public Car() {
    }

    private Integer id;
    @NotNull private Brand brand;
    private String regNumber;
    private Double price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && brand == car.brand && Objects.equals(regNumber, car.regNumber) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, regNumber, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", regNumber='" + regNumber + '\'' +
                ", price=" + price +
                '}';
    }




    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }



    public Car(Integer id, Brand brand, String regNumber, Double price) {
        this.id = id;
        this.brand = brand;
        this.regNumber = regNumber;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



}
