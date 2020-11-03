package OOP.SuminJava.Abstract;

public class FigureMain {
    public static void main(String[] args) {

        Figure triangle = new Triangle();
        triangle.printFigure();
        Figure coloreTriangle = new ColorTriangle(10,"Красный");
        coloreTriangle.printFigure();

    }
}
