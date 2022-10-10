public class JavaMethods {
    public static void main(String[] args) {

        helloWorld();
        nameSurname();
        nameSurnameGiven("Ahmet", "Yılmaz");
        getDivide(50,10);
        getDivide(100, 5,4);
        int square = square(5);
        System.out.println("square = " + square);
    }
    private static void helloWorld () {
        System.out.println("Hello World");
    }

    private static void nameSurname() {
        System.out.println("Uğur Gürler");
    }

    private static void nameSurnameGiven(String name, String surname) {
        System.out.println("Ad Soyad: " + name + " " + surname);
    }

    private static void getDivide (int a, int b) {
        int divide = a / b;
        System.out.println(divide);
    }

    private static void getDivide (int a, int b, int c) {
        int divide = a / b / c;
        System.out.println(divide);
    }

    private static int square(int a) {
        int square = a * a;
        return square;
    }

}
