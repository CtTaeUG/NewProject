import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Ahmet");
        myList.add("Ugur");
        myList.add("Ayse");
        myList.add("Fatma");

        System.out.println(myList);

        System.out.println(myList.get(0));
        myList.set(1, "Cevdet");
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println(myList.indexOf("Ayse"));

        String removed = myList.remove(3);
        System.out.println(myList);
        System.out.println(removed);

        myList.add("Burak");
        myList.add("Deniz");
        myList.add("Cimcime");
        myList.add("Ferdi");

        System.out.println(myList);
        System.out.println(myList.size());

        System.out.println(myList.contains("Ugur"));
        System.out.println(myList.contains("Ferdi"));

        System.out.println(myList.indexOf("Ferdi"));
        System.out.println(myList.isEmpty());


        for (String value: myList) {
            //System.out.println(value);
            System.out.println(value);
        }


        Iterator<String> iterator = myList.iterator();
        String name = iterator.next();
        System.out.println("Name is: " + name);

        String secondName = iterator.next();
        System.out.println("Name is: " + secondName);



        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
