
//https://www.codewars.com/kata/find-the-smallest/train/java

import java.util.Arrays;

public class ToSmallest {

    public static long[] smallest(long n) {
        long min = n;
        int index1 = 0;
        int index2 = 0;
        String number = String.valueOf(n);
        for (int i=0; i<number.length(); i++) {
            for (int j=0; j<number.length(); j++) {
                if (i!=j && making(number, i, j) < min) {
                    min = making(number, i, j);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return new long[]{min, index1, index2};
    }

    public static long making(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(i);
        sb.deleteCharAt(i);
        sb.insert(j, c);

        return Long.valueOf(sb.toString());
    }
//    public static long[] smallest(long n) {
//        String num = String.valueOf(n);
//        char[] chars = new char[num.length()];
//        num.getChars(0, chars.length, chars, 0);
//        int min_i = -1, min_j = -1;
//        long min = n;
//        for (int i = 0; i < chars.length; i++) {
//            for (int j = 0; j < chars.length; j++) {
//                if(i!=j) {
//                    long l = moveDigitAndGetLongValue(chars, i, j);
//                    if (l < min) {
//                        min = l;
//                        min_i = i;
//                        min_j = j;
//                    }
//
//                    if (l==min && i < min_i) {
//                        min_i = i;
//                        min_j = j;
//                    }
//                }
//
//            }
//        }
//
//        long[] result = new long[3];
//        result[0] = min;
//        result[1] = Math.min(min_i, min_j);
//        result[2] = Math.max(min_i, min_j);
//        return result;
//    }
//
//    private static long moveDigitAndGetLongValue(char[] arr, int i, int j) {
//        char[] dest = new char[arr.length];
//        System.arraycopy(arr, 0, dest, 0, arr.length);
//        char temp = arr[i];
//        if (i<j) {
//            System.arraycopy(arr, i+1, dest, i, j-i);
//        } else {
//            System.arraycopy(arr, j, dest, j+1, i-j);
//        }
//
//        dest[j] = temp;
//        return Long.parseLong(String.valueOf(dest));
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallest(261235)));
    }
}