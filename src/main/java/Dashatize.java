import java.util.stream.IntStream;

//https://www.codewars.com/kata/dashatize-it
public class Dashatize {

    public static String dashatize(int num) {
        StringBuilder builder = new StringBuilder();
        String numStr = String.valueOf(num);
        IntStream.range(0, numStr.length())
                .forEach(i -> {
                    char ch = numStr.charAt(i);
                    if (ch == '-') return;
                    int digit = digit(ch);
                    if (isOdd(digit)) {
                        if(builder.length() > 0 && !isOdd(digit(numStr.charAt(i-1)))) {
                            builder.append("-");
                        }
                    }
                    builder.append(digit);
                    if (isOdd(digit)) {
                        if(i != numStr.length()-1) {
                            builder.append("-");
                        }
                    }
                });

        return builder.toString();
    }

    private static int digit(char ch) { return Character.digit(ch, 10); }
    private static boolean isOdd(int num) { return num % 2 == 1; }

    public static void main(String[] args) {
        System.out.println(dashatize(Integer.MIN_VALUE));
    }
}