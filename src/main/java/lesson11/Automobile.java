package lesson11;

abstract public class Automobile {
    public String numberPlate;
    public double wight; //тонны
    public double totalHeight; //метры
    public double fullWidth; //метры
    public double totalLength; //метры
    public double speed; //км в час
    public boolean type; //км в час
    public String model; //модель

    public void move() throws CheckpointException{
       System.out.println(" модель " + model + " поехал на скорости " + speed + " через КПП");
    }

    public Automobile(String numberPlate, double wight, double totalHeight, double fullWidth, double totalLength, double speed, boolean type, String model) {
        this.numberPlate = numberPlate;
        this.wight = wight;
        this.totalHeight = totalHeight;
        this.fullWidth = fullWidth;
        this.totalLength = totalLength;
        this.speed = speed;
        this.type = type;
        this.model = model;
    }
}
