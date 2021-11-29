package lesson8;

public class Parrot extends Animals {
    private static String SOUND = "ааааа аааар";

    public void voice() {
        System.out.println(name + " говорит " + SOUND);
    }

    public Parrot(String name) {
        super(name);
    }
}
