package com.company;

public class Engine {
    private String serialNumber;
    private String typeOfFuel;

    private int power;
    private int workingVolume;
    private int numberCylinders;

    private double consumption;

    Engine (
            int power,
            String serialNumber,
            int workingVolume,
            int consumption,
            String typeOfFuel,
            int numberCylinders
    ) {
        this.power = power;
        this.serialNumber = serialNumber;
        this.workingVolume = workingVolume;
        this.consumption = consumption;
        this.typeOfFuel = typeOfFuel;
        this.numberCylinders = numberCylinders;
    }

    public void print() {
        System.out.println("Power: " + this.power);
        System.out.println("Serial number: " + this.serialNumber);
        System.out.println("Working Volume: " + this.workingVolume);
        System.out.println("Consumption: " + this.consumption);
        System.out.println("Type of fuel: " + this.typeOfFuel);
    }

    //setters
    public void setPower(int power) { this.power = power; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setWorkingVolume(int workingVolume) { this.workingVolume = workingVolume; }
    public void setConsumption(double consumption) { this.consumption = consumption; }
    public void setNumberCylinders(int numberCylinders) { this.numberCylinders = numberCylinders; }
    public void setTypeOfFuel(String typeOfFuel) { this.typeOfFuel = typeOfFuel; }

    //getters
    public int getPower() { return power; }
    public double getConsumption() { return consumption; }
    public int getNumberCylinders() { return numberCylinders; }
    public int getWorkingVolume() { return workingVolume; }
    public String getSerialNumber() { return serialNumber; }
    public String getTypeOfFuel() { return typeOfFuel; }
}
