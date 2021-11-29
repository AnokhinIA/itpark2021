package lesson8;

public class EighthProgram {
    public static void main(String[] args) {
        Cats bars = new Cats("Барс");
        Cats murzik = new Cats("Мурзик");
        Dogs slesh = new Dogs ("Слэш");
        Dogs lora = new Dogs ("Лора");
        Parrot yasha = new Parrot ("Яша");

        Animals[] animals = new Animals[] {bars,murzik,slesh,lora,yasha};
        for (Animals animal:animals) {
            animal.voice();
        }
    }
}
