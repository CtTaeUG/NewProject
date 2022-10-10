public class Lamp {
    public boolean lightStatus = false;
    private String roomName;

    public Lamp(String room){
        roomName = room;
        System.out.println("Creating an object of "  + room + " the lamp class");

    }
    public void printLightStatus() {
        if (lightStatus) {
            System.out.println("Tle lamp is on");
        } else {
            System.out.println("The lamp is off");
        }
    }
}
