public class IfElse {
    public static void main(String[] args) {
        int y = 55;
        boolean isTrue = y < 50;
        if (isTrue) {
            System.out.println(y + " is less than 50");
        } else {
            System.out.println(y + " is more than 50");
        }

        int time = 1100;

        if(time < 1200) {
            System.out.println("Say: Good Morning");
        } else if (time >= 1200 && time < 1800) {
            System.out.println("Say: Good Afternoon");
        } else {
            System.out.println("Say: Good Evening");
        }
    }
}
