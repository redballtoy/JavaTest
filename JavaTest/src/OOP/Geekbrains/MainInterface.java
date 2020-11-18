package OOP.Geekbrains;

public class MainInterface {
    public static void main(String[] args) {
        //массив объектов не основе интерфейса
        //например массив летающих
        Duck flyedDuck = new Duck("flyedDuck");
        AirPlane airPlane = new AirPlane();
        //любой объект данного массива имеет только один метод fly()
        FlyAndVoice[] fly = {flyedDuck, airPlane};
        for (Fly fly1 : fly) {
            fly1.fly();

        }


    }

}
