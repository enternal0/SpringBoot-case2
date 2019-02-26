package com.dan.springboot.BuilderModel;

import lombok.Data;

//Builder模式,没写好，有问题，下去改改
@Data
public class Car {
    private String meter="真皮";
    private String brand="大众";
    private String color="white";

    private Car(){}
    public static class CarBuiler{
        private Car car=new Car();

        public CarBuiler color(String color) {
            this.car.setColor(color);
            return Car.getCar();
        }
        public CarBuiler brand(String brand){
            this.car.setBrand(brand);
            return Car.getCar();
        }
        public CarBuiler meter(String meter){
            this.car.setMeter(meter);
            return Car.getCar();
        }
        private Car build(){
            return this.car;
        }

    }
    public static CarBuiler getCar(){
        return new CarBuiler();
    }

    public static void main(String[] args) {
        Car car=Car.getCar().build();
        System.out.println(car);
        System.out.println(Car.getCar().color("紫色").meter("织物").build());
    }
}
