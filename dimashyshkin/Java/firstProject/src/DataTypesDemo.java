public class DataTypesDemo {
    public static void main(String[] args) {
        byte myByte = 127;
        short myShort = 687;
        int myInteger = 2789836;
        long myLong = 33492347203470L;
        float myFloat = 2.45f;
        double myDouble = 5.6778;
        boolean myBoolean = true;
        char myChar = 'f';

        int newInt = myByte;
        System.out.println("myByte = " + myByte);

        int newIntFromMyDouble = (int) myDouble;
    }
}
