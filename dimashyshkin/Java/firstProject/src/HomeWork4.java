import java.util.SortedMap;

public class HomeWork4 {
    public static void main(String[] args) {

        String str = "Hello world";
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'o') {
                newStr += 0;
            } else {
                newStr += str.charAt(i);
            }
        }

        System.out.println(newStr);

    }
}
