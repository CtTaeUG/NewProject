public class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark!");
    }

    @Override
    public void sleep(){
        super.sleep();
        System.out.println("Dog is sleeping");
    }
}
