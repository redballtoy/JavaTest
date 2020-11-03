package OOP.SuminJava.Inheritance;

public class CatFamily {
    protected int ears;
    protected int legs;
    protected boolean hasBigClaws;

    public CatFamily() {
        ears=2; //ухов
        legs=4; //лап
        hasBigClaws = true;//есть большие когти
    }

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
}
