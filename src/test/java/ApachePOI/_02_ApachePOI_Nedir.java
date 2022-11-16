package ApachePOI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class _02_ApachePOI_Nedir {
    /**
     * Interview SORUSU
     * 1- Excelden veri okumasını nasıl yaparsınız ?
     * Apache.POI ile yapıyorum.
     *
     * 2- ApachePOI nedir ?
     * Excelden veri okuma aracı, kütüphanesi

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

        String hak="Ey vefalı dost! senin hakkını asla ödeyemem.";
        String harfler= getInitials(hak);
        System.out.println("harfler = " + harfler);

        System.out.println(letterNumber("AAABBBBCCCC"));

        int [] tek = {1,3,5,9,11,15};
        for(int g=0; g< tek.length-1; g++)
            if((tek[g]+2)!=tek[g+1])
                System.out.println("absent = " + (tek[g]+2));

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
    public static String getInitials(String r){
        String value="";
        String[]arr=r.split(" ");
        for (int i = 0; i < arr.length; i++) {
            value+=arr[i].charAt(0)+" ";
        }
     return value;
    }

    public static int letterNumber(String qa){
        int number=0;
        for(int i=0; i<qa.length(); i++)
            if((qa.charAt(i))=='A') number++;

        return number;
        }


    }



