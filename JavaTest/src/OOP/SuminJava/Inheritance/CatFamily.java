package OOP.SuminJava.Inheritance;

public class CatFamily {
    protected int ears;
    protected int legs;
    protected boolean hasBigClaws;

    public CatFamily(int ears, int legs, boolean hasBigClaws) {
        this.ears = ears;
        this.legs = legs;
        this.hasBigClaws = hasBigClaws;
    }

    @Override
    public String toString() {
        return "CatFamily{" +
                "ears=" + ears +
                ", legs=" + legs +
                ", hasBigClaws=" + hasBigClaws +
                '}';
    }
    public String eat() {
        return "Кушвю еду";
    }
}
