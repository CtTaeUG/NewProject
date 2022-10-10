package HomeWork;

public class Car {

    protected String make;
    protected String model;
    protected int miles;
    protected int price;
    protected int doors;

    public Car(String make, String model, int miles, int price, int doors) {
        this.make = make;
        this.model = model;
        this.miles = miles;
        this.price = price;
        this.doors = doors;
    }

    public void drive (int miles) {
        this.miles += miles;
        System.out.println("Car went for " + miles);
    }


    public void forSale (int newPrice) {
        this.price = newPrice;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", miles=" + miles +
                ", price=" + price +
                ", doors=" + doors +
                '}';
    }
}
