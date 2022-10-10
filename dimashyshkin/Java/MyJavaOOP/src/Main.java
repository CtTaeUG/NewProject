public class Main {
    public static void main(String[] args) {
        /*ClassDemo instance = new ClassDemo();
        instance.printNumber();

        ClassDemo newInstance = new ClassDemo();
        newInstance.printNumber();*/

        Lamp kitchenLamp = new Lamp("kitchen");
        Lamp bedroomLamp = new Lamp("bedroom");

        kitchenLamp.printLightStatus();
        bedroomLamp.printLightStatus();

        kitchenLamp.lightStatus = true;
        kitchenLamp.printLightStatus();
        bedroomLamp.printLightStatus();

        Lamp toiletLamp = new Lamp("toilet");
        toiletLamp.printLightStatus();

    }
}
