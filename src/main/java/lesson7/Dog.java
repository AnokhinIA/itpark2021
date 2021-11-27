package lesson7;

public class Dog {

    int maximumRunDistance;
    int maximumSwimDistance;

    public String ran (int distance) {
        if (distance < maximumRunDistance) {
            return "Собака пробежала " + distance + " метров";
        }else{
            return "Собака пробежала " + maximumRunDistance + " метров. Это предельное значение.";
        }
    }
    public String swim (int distance) {
        if (distance < maximumSwimDistance) {
            return "Собака проплыла" + maximumSwimDistance + " метров";
        }else{
            return "Собака проплыла " + maximumSwimDistance + " метров. Это предельное значение.";
        }
    }
    public Dog(int maximumRunDistance, int maximumSwimDistance) {
        this.maximumRunDistance = maximumRunDistance;
        this.maximumSwimDistance = maximumSwimDistance;
    }
}
