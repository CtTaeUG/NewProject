public class InterfaceDemo implements A, B {
    @Override
    public void printMessage() {
        System.out.println("Implemented from A");
    }

    @Override
    public void printNewMessage() {
        System.out.println("Implemented from B");

    }
}
