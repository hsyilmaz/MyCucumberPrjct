package ApachePOI;

import java.util.ArrayList;
import java.util.Arrays;

public class _02_ApachePOI_Nedir {
    /**
     * Interview SORUSU
     * 1- Excelden veri okumasını nasıl yaparsınız ?
     * Apache.POI ile yapıyorum.
     * <p>
     * 2- ApachePOI nedir ?
     * Excelden veri okuma aracı, kütüphanesi
     * <p>
     * 3- ApachePOI yi nasıl kullanıyorsun ?
     * FileInputStream oluşturuyorum. (Dosyayı yani Exceli okuma için açma)
     * FileInputStream -> Workbook -> Sheet -> row -> cell ilşki sırasına göre okuyorum.
     */


    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> M = method(x);
        System.out.println("M = " + M);
        int[] d = methd(x);
        System.out.println(Arrays.toString(d));
        System.out.println(fact(5));
        System.out.println(summing(5, 3, 4, 5, 6, 7, 8));


    }

    public static ArrayList<Integer> method(int[] a) {
        ArrayList<Integer> m = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                m.add(a[i]);
            }
        }
        return m;
    }

    public static int[] methd(int[] b) {
        int[] list = new int[b.length / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 2 == 1) {
                list[j] = b[i];
                j++;
            }

            /*for (int k : b) {
            if (k % 2 == 1) {
                list[j] = k;
                j++;*/
        }
        return list;
    }

    public static int fact(int x) {
        int factMultiply = 1;
        while (x > 0) {
            factMultiply *= x;
            x--;
        }
        return factMultiply;
    }

    public static int summing(int... c) {
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum += c[i];
        }
        return sum;
    }
}


