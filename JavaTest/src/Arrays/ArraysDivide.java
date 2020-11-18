package Arrays;

public class ArraysDivide {

    //прикольная возможность разделить один на другой
    public static void main(String[] args) {
        int[] arr = {5, 7, 5, 2, 5, 7};
        int[] arrDiv = {5, 7, 5, 2, 5, 7};
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= arrDiv[i];
        }
        for (int i : arr)
            System.out.print(String.valueOf(i) + " ");
    }
}
