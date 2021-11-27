package lesson7;

public class SeventhProgram {
    public static void main(String[] args) {
        Cat cat = new Cat(400);
        Dog dog = new Dog (500,150);
        Fish fish = new Fish(600);

        System.out.println(cat.swim(100));
        System.out.println(cat.ran(500));
        System.out.println("-----------------------");
        System.out.println(dog.swim(1000));
        System.out.println(dog.ran(400));
        System.out.println("-----------------------");
        System.out.println(fish.swim(1000));
        System.out.println(fish.ran(400));
    }
}
