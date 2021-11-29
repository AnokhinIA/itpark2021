package lesson8;

public class Cats extends Animals {
    private static String SOUND = "мяу";

    public void voice() {
        System.out.println(name + " говорит " + SOUND);
    }

    public Cats(String name) {
        super(name);
    }
}
