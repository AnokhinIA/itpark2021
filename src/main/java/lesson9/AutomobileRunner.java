package lesson9;

public class AutomobileRunner {
    public static void main(String[] args) {
        String[] types = new String[]{"Lada", "Mitsubishi", "Toyota", "Nissan", "Ford", "BMW", "Citroen", "Renault", "Volkswagen", "Mercedes"};
        Car[] myCars = new Car[10];
        for (int i = 0; i < 10; i++) {
            myCars[i] = new Car();
            myCars[i].setType(types[i]);
            myCars[i].move(Math.random() * 1000);
        }
        Truck[] myTrucks = new Truck[10];
        for (int i = 0; i < 10; i++) {
            myTrucks[i] = new Truck();
            myTrucks[i].setType("Грузовик № " + i);
            myTrucks[i].move(Math.random() * 1000);
        }


    }
}
