import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> age = new HashMap<>();
        age.put("Ugur", 32);
        age.put("Ahmet", 35);
        age.put("Ayse", 31);
        age.put("Veli", 42);

        System.out.println(age);

        System.out.println(age.get("Ayse"));

        System.out.println("All keys: " + age.keySet());
        System.out.println("All values: " + age.values());
        System.out.println("All pairs: " + age.entrySet());

        age.replace("Veli", 44);
        System.out.println(age);

        age.remove("Ahmet");
        System.out.println(age);

        Iterator iterator = age.entrySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("**********");

        Iterator<Map .Entry<String, Integer>> entryIterator = age.entrySet().iterator();

       /*while (entryIterator.hasNext()) {
            System.out.println(entryIterator.next());
        }

        System.out.println("**********");

        */

        /*while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }

         */

        for (Map.Entry<String, Integer> entry: age.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }

    }
}
