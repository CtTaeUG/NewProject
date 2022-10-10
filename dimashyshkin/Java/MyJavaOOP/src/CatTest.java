public class CatTest {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom", "American Short Hair");

        cat.setName("Simba");
        String catName = cat.getName();
        System.out.println(catName);

        cat.makeSound();
        cat.sleep();

    }
}
