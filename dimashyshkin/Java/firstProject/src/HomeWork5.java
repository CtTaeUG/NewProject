public class HomeWork5 {
    public static void main(String[] args) {
        int average = getAverage(15, 10, 5);
        System.out.println("average = " + average);

    }

    private static int getAverage (int a, int b, int c) {
        int average = (a + b + c) / 3;
        return average;
    }
}
