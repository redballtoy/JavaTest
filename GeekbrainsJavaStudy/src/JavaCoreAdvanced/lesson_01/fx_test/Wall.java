package JavaCoreAdvanced.lesson_01.fx_test;

public class Wall {
    private String name;
    private int wall;

    public Wall() {
        this.wall =(int) (Math.random() * 1500);
        System.out.println("Высотв этой стены"+this.name+" соствляет " + this.wall + " метров");
    }

    public String getName() {
        return name;
    }

    public int getWall() {
        return wall;
    }
}
