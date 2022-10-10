public class MyArray {
    public static void main(String[] args) {
        String[] students = {"Ugur", "Ahmet", "Ayse"};
        int[] numbers = {5, 7, 9, 11};

        System.out.println(students[0]);
        System.out.println(numbers[2]);

        System.out.println("There are " + students.length + " students in the class");

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }


    }
}
