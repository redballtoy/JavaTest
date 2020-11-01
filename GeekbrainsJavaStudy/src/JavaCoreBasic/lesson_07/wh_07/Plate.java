package JavaCoreBasic.lesson_07.wh_07;

public class Plate {

    private int capacity = 0;
    private int currentCapacity = 0;

    public Plate(int capacity) {
        this.capacity = capacity;
    }

    public void addFood(int currentCapacity) {
        if (currentCapacity <= (this.capacity - this.currentCapacity)) {
            this.currentCapacity += currentCapacity;
            System.out.println("\nДобавили корма в миску: "+currentCapacity);
        }else {
            System.out.println("\nВы хотели добавить еще: "+currentCapacity);
            System.out.println("Столько корма в миску не влезет!");
        }
    }
    public void showInfo() {
        System.out.println("\nВместимость миски: " + this.capacity);
        System.out.println("Сейчас корма в миске: " + this.currentCapacity);
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
}
