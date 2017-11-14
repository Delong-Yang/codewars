import java.util.TreeSet;

// https://www.codewars.com/kata/hamming-numbers/

public class Hamming {

    public static long hamming(int n) {
        if (n <= 0) return -1;
        TreeSet<Long> ts = new TreeSet<>();
        long smallest = 1;
        ts.add(smallest);
        for (int i = 0; i < n; i++) {
            smallest = ts.pollFirst();
            ts.add(smallest * 2);
            ts.add(smallest * 3);
            ts.add(smallest * 5);
        }
        return smallest;
    }


    public static void main(String[] args) {
        System.out.println(hamming(7));
    }

}