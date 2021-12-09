package lesson11;

public class Car extends Automobile{
    private final String overSpeed100 = speed + "Скорость > 100 км/ч., автомобиль с гос. номером " + numberPlate + " задержан полицией";
    private final String overWight8 = "Вес > 8 тонн, проезд для автомобиля с гос. номером " + numberPlate + " запрещен.";
    private final String totalHeight4 = "Высота авто > 4 м, проезд для автомобиля с гос. номером " + numberPlate + " запрещен.";
    private final String fullWidth2_5 = "Ширина авто > 2.5 м, проезд для автомобиля с гос. номером " + numberPlate + " запрещен.";
    private final String overSpeed80 = "Скорость > 80, предупреждение для автомобиля с гос. номером " + numberPlate;

    @Override
    public void move() throws CheckpointException{
        super.move();
        if (speed > 100) throw new CheckpointException(overSpeed100);
        if (wight > 8) throw new CheckpointException(overWight8);
        //Габариты авто не должны превышать 4 м высоты и 2.5 м ширины (иначе генерируется исключение, указанное в п.1)
        if (totalHeight > 4) throw new CheckpointException(totalHeight4);
        if (fullWidth > 2.5) throw new CheckpointException(fullWidth2_5);
        if (speed > 80) throw new CheckpointException(overSpeed80);
        //Вес автомобиля не должен превышать 8 тон (в противном случае генерируется исключение о невозможности проезда и указании номера авто и его типа)
        System.out.println(" Все в порядке, КПП проехали успешно.");
        System.out.println(" ------------------------");
    }

    public Car(String numberPlate, double wight, double totalHeight, double fullWidth, double totalLength, double speed, boolean type, String model) {
        super(numberPlate, wight, totalHeight, fullWidth, totalLength, speed, type, model);
    }
}
