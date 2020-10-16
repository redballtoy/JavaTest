package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lib;

public class MyMath {
    public static int minMaxInt(int[]a, String max_min){
        int max = 0;
        int min = 0;

        for (int i = 0; i <a.length ; i++) {
            min = a[i]< min ? a[i] : min;
            max = a[i] > max ? a[i] : max;

        }

        if (max_min.equals("max")) {
            return max;
        }
        return min;

    }
}
