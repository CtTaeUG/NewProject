public class MyString {
    public static void main(String[] args) {
        String myFullName = "Ugur Gurler";
        System.out.println("myFullName = " + myFullName);

        int myFullNameLength = myFullName.length();
        System.out.println("myFullNameLength = " + myFullNameLength);

        String myFullNameUpperCase = myFullName.toUpperCase();
        String myFullNameLowerCase = myFullName.toLowerCase();

        System.out.println("myFullNameLowerCase = " + myFullNameLowerCase);
        System.out.println("myFullNameUpperCase = " + myFullNameUpperCase);

        String mergeUpperAndLowerCase = myFullNameLowerCase + " " + myFullNameUpperCase;
        System.out.println(mergeUpperAndLowerCase);
    }
}
