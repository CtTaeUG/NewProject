public class JavaLoops {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 6) {
                System.out.println("STOP");
                break;
            }
        }

        String[] students = {"Ugur", "Ahmet", "Ayse"};
        for (String student : students){
            System.out.println(student);
        }


    }
}
