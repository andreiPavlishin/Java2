package Lesson5;

import java.util.Arrays;

@SuppressWarnings("IntegerDivisionInFloatingPointContext")
public class MainClass5_1 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        singleThread();
        multiThread();
    }

    public static void singleThread() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i /5) * Math.cos(0.4f + i /2));
        }
        long b = System.currentTimeMillis();
        System.out.println("Первый метод: " + (b - a));
    }

    public static void multiThread() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(() -> calculate(a1));
        Thread t2 = new Thread(() -> calculate(a2));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long b = System.currentTimeMillis();
        System.out.println("Второй метод: " + (b - a));
    }

    public static void calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i /5) * Math.cos(0.4f + i /2));
        }
    }
}
//Первый метод: 9967
//Второй метод: 2728
//Первый метод: 10078
//Второй метод: 2722