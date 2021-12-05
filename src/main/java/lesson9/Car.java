package lesson9;

public class Car extends Automobile {
    String type;

    @Override
    public void move(double distance) {
        if (distance >= 500) {
            System.out.println("Максимум для " + type + " 500 км., а у вас: " + distance);
        } else {
            System.out.println(type + " проехала: " + distance);
        }
    }

    @Override
    int parking(int distance2) {
        return 0;
    }

    public void setType(String type) {
        this.type = type;
    }
}
