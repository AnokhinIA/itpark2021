package lesson9;

public class Truck extends Automobile {
    String type;

    @Override
    void move(double distance) {
        if (distance >= 1200) {
            System.out.println("Максимум для " + type + " 1200 км., а у вас: " + distance);
        } else {
            System.out.println(type + " проехал: " + distance);
            System.out.println(type + " остановился поссать на: " + this.parking((int)distance) + " км.");
        }
    }

    @Override
    int parking(int distance2) {
        distance2 = distance2 /2;
        return distance2;
    }

    public void setType(String type) {
        this.type = type;
    }
}

