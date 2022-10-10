public class WLoop {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        do {
            if (i == 2) {
                System.out.println("Skipping 2");
                i--;
                continue;
            }
            System.out.println(i);
            i--;
        } while (i > 0);
    }
}
