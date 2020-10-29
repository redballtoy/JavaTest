package OOP.SuminJava;

public class Box {
    double width;
    double height;
    double lenght;

    public Box() {
        width = 10;
        lenght = 10;
        height = 10;
    }

    void setDimens(double width, double height, double lenght) {
        this.width = width;
        this.height = height;
        this.lenght = lenght;
    }

    public double getVolume() {
        return Math.round(width * lenght * height);
    }

    public void printVolume() {
        System.out.println("volume: " + getVolume());
    }



}
