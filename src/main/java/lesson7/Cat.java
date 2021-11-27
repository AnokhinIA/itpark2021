package lesson7;

public class Cat {
    int maximumDistance;

    public String ran (int distance) {
        if (distance < maximumDistance) {
            return "Кошка пробежала" + distance + " метров";
        }else{
            return "Кошка пробежала " + maximumDistance + " метров. Это предельное значение.";
            }
        }
     public String swim (int distance) {
        return "Кошка не умеет плавать и не может проплыть " + distance + " метров";
     }
    public Cat(int runDistance) {
        this.maximumDistance = runDistance;

    }
}
