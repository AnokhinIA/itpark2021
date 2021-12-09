package lesson11;

public class CarRunner {
    public static void main(String[] args) {

        Automobile[] cars = new Automobile[10];
        String[] numberPlate = new String[]{"п222ро56", "е234еа04", "е222ее04", "е111ем03", "е099ву02", "м091ев01", "м090ев90", "e001pp55", "o100oo23", "H203TM199"};
        double wight; //тонны
        double totalHeight; //метры
        double fullWidth; //метры
        double totalLength; //метры
        double speed; //км в час
        String[] model = new String[]{"Lada", "Mitsubishi", "Toyota", "Nissan", "Ford", "BMW", "Citroen", "Renault", "Volkswagen", "Mercedes"};

        for (int i = 0; i < 10; i++) {
            wight = Math.random() * 4;
            totalHeight = Math.random() * 4;
            fullWidth = Math.random() * 4;
            totalLength = Math.random() * 4;
            speed = Math.random() * 100;

            cars[i] = new Car(numberPlate[i], wight, totalHeight, fullWidth, totalLength, speed, true, model[i]);

            try {
                cars[i].move();
            } catch (CheckpointException e) {
                System.out.println(e.getMessage());
                System.out.println(" ------------------------");
            }
        }
    }
}