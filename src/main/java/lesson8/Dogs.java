package lesson8;

public class Dogs extends Animals {
    private static String SOUND = "гав";

    public void voice() {
        System.out.println(name + " говорит " + SOUND);
    }

    public Dogs(String name) {
        super(name);
    }
}
