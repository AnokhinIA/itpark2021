package lesson7;

public class Fish {
    int maximumSwimDistance;
    public String swim (int distance) {
        if (distance < maximumSwimDistance) {
            return "Рыбкк проплыла " + distance + " метров";
        }else{
            return "Рыбкк проплыла " + maximumSwimDistance + " метров. Это предельное значение.";
        }
    }
    public String ran (int distance) {
        return "Рыбка не умеет бегать и не может пробежать " + distance + " метров";
    }


    public Fish(int maximumSwimDistance) {
        this.maximumSwimDistance = maximumSwimDistance;
    }
}
