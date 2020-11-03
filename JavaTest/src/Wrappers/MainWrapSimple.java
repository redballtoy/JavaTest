package Wrappers;

public class MainWrapSimple {
    public static void main(String[] args) {
        int a = 5;
        Integer b = 5; //происходит автоупаковка из примитивного типа в объектный

        //пример когда требуется использовать оболочки
        String s = "1000";
        String test = "2000";
        int as = Integer.parseInt(s);
        int itest = Integer.parseInt(test);
        System.out.println(as + itest);

        String bl = "false";
        boolean abl = Boolean.parseBoolean(bl);//при true все преобразует в true, все остальное в false
        if (!abl) {
            System.out.println(abl);
        }
    }
}
