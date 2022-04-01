package com.company;

enum CarStatus {
    Flight,
    Repair,
    Base,
    None,
}

public class CarBase {
    private int maxCars;
    private CarStatus statusCar;

    private Car[] Cars;

    CarBase(int maxCars) {
        this.maxCars = maxCars;
        this.Cars = new Car[maxCars];
    }

    public void addCar (Car car) {
        for (int i = 0; i < maxCars; i++) {
            if (Cars[i] == null) {
                Cars[i] = car;
                this.Cars[i].setCurrentStatus(CarStatus.Flight);
                break;
            } else System.out.println("Автобаза переполнена! максимум: " + this.maxCars);
        }
    }

    public void deleteCar (Car car) {
        for (int i = 0; i < maxCars; i++) {
            if (Cars[i] == null) break;
            else if (Cars[i] == car) Cars[i] = null;
        }
    }


    public void stepFix () {

    }

    public void printCurentCars () {
        System.out.println("Автобаза");

        System.out.println(String.format("---------------------------------------------"));
        System.out.println(String.format("| %-2s | %-10s | %-10s","№" ,"Бренд", "Цвет       | Статус     |"));
        System.out.println(String.format("---------------------------------------------"));
        for (int i = 0; i < maxCars; i++) {
            if (Cars[i] != null)  {
                String s = String.format("| %-2s | %-10s | %-10s | %-10s |", i + 1, Cars[i].getBrand(), Cars[i].getColor(), Cars[i].getCurrentStatus());
                System.out.println(s);
            }
        }
        System.out.println(String.format("---------------------------------------------"));
    }
}
