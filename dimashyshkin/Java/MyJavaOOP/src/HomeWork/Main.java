package HomeWork;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Sedan("Toyota", "Coralla", 2500, 20000, 4);
        Car car2 = new Coupe("Chevrolet", "Camaro", 4000, 25000, 2);

        car1.drive(1000);
        car2.drive(1500);

        car1.forSale(15000);
        car2.forSale(20000);
    }
}
