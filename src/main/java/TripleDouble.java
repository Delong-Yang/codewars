// https://www.codewars.com/kata/triple-trouble-1/
public class TripleDouble {

    public static int TripleDouble(long num1, long num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        boolean[] flags = new boolean[10];
        for (int i = 0; i <= s1.length() - 3; i++) {
            if (s1.charAt(i) == s1.charAt(i + 1)
                    && s1.charAt(i) == s1.charAt(i + 2)) {
                flags[Character.digit(s1.charAt(i), 10)] = true;
            }
        }

        for (int i = 0; i <= s2.length() - 2; i++) {
            if (s2.charAt(i) == s2.charAt(i + 1)
                    && flags[Character.digit(s2.charAt(i), 10)]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(TripleDouble.TripleDouble(10560002L, 100L));
    }
}