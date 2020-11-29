package JavaCoreAdvanced.lesson_05.HW_05;

public class Main {

    private static final int ARRAY_SIZE = 10000000;
    private static float[] bigArray = new float[ARRAY_SIZE];
    private static float[] halfArray1 = new float[ARRAY_SIZE / 2];
    private static float[] halfArray2 = new float[ARRAY_SIZE / 2];


    public static void main(String[] args) {

        System.out.println("Время последовательного заполнения массива в один поток = " +
                sequentialFillingArray(bigArray) + " миллисекунд");

        System.out.println("Время заполнения массива в два потока = " +
                asynchFillingArray(bigArray,halfArray1,halfArray2)+ " миллисекунд");

    }

    private static long asynchFillingArray(float[] bigArray, float[] halfArray1, float[] halfArray2) {
        long startTime = System.currentTimeMillis();
        sequentialFillingArray(halfArray1);
        sequentialFillingArray(halfArray2);
        arrayCopy();
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;

    }

    private static long  sequentialFillingArray(float[] arr) {
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread();
        thread.setPriority(5);
        thread.start();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));

            //arr[i]=3;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }
    private static void arrayCopy() {
        //копируем оба массива в один
        /*
        System.out.println("halfArray1 = " + Arrays.toString(halfArray1));
        System.out.println("halfArray2 = " + Arrays.toString(halfArray2));
        for (int i = 0; i < bigArray.length ; i++) {
            bigArray[i] = 1;
        }

        System.out.println(Arrays.toString(bigArray));
         */
        System.arraycopy(halfArray1, 0, bigArray, 0, halfArray1.length);
        System.arraycopy(halfArray2, 0, bigArray, bigArray.length/2, halfArray2.length);
        //System.out.println(Arrays.toString(bigArray));
    }

}
