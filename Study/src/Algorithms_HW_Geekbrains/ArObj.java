package Algorithms_HW_Geekbrains;


public class ArObj {
    private int x;
    private int y;

    public ArObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void print() {
        System.out.println("X= " + this.x + "; Y=" + this.y);
    }
    public String getYX() {
        return "X= " + this.x + "; Y=" + this.y;
    }
}