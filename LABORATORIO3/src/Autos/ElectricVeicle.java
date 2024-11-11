package Autos;

class ElectricVehicle extends Vehicle {
    private double batteryCapacity;
    private int range;

    public ElectricVehicle(String brand, String model, double price, double batteryCapacity, int range) {
        super(brand, model, price);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }

    public void displayRange() {
        System.out.println("Range: " + range + " km");
    }
}