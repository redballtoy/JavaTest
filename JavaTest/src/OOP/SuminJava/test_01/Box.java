package OOP.SuminJava.test_01;

public class Box {
    double width;
    double height;
    double lenght;

    public Box(double width, double height, double lenght) {
        this.width = width;
        this.height = height;
        this.lenght = lenght;
    }

    public Box(double size) {
        width = size;
        lenght = size;
        height = size;

    }

    public Box() {
        width = 0;
        lenght = 0;
        height = 0;

    }

    //создание коробки по размерам другой коробки
    public Box(Box box) {
        width = box.width;
        height = box.height;
        lenght = box.lenght;
    }


    public double getVolume() {
        return Math.round(width * lenght * height);
    }

    public void showDimension(String name) {
        System.out.println("\nРазмеры коробки "+ name+" таковы:"
                + "\nwidth:\t" + width
                + "\nlength:\t" + lenght
                + "\nheight:\t" + height);
    }


    public void printVolume() {
        System.out.println("volume: \t\t\t" + getVolume());
    }

    void compareTo(Box box) {
        System.out.println("\nСравненение объемов коробок:");
        double thisVolume = getVolume();
        double boxVolume = box.getVolume();
        System.out.print("volume thisVolume:" + thisVolume + "\tvolume boxVolume:" + boxVolume + "\t");
        if (thisVolume > boxVolume) {
            System.out.println("- коробка thisVolume больше");
        } else if (thisVolume < boxVolume) {
            System.out.println("- коробка thisVolume меньше");
        } else {
            System.out.println("- коробки одинаковы");
        }
    }

    //метод возвращающий коробку в 2 раза больше чем у вызывающей
    public Box increaseBoxDim(int i) {
        return new Box(width * i, height * i, lenght * i);
    }


}
