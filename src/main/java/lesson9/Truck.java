package lesson9;

public class Truck extends Automobile {
    String type;

    @Override
    void move(double distance) {
        if (distance >= 200) {
            System.out.println("Максимум для " + type + " 200 км., а у вас: " + distance);
        } else {
            System.out.println(type + " проехал: " + distance);
        }
    }

    public void setType(String type) {
        this.type = type;
    }
}

