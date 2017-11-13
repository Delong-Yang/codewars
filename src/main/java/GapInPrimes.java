import java.util.*;
import java.util.stream.LongStream;

//https://www.codewars.com/kata/561e9c843a2ef5a40c0000a4

public class GapInPrimes {
    private static Map<Long, Boolean> map = new HashMap<>();
    private static long NOT_FOUND = -1;

    public static long[] gap(int g, long m, long n) {
        long candidate = LongStream.rangeClosed(m, n - g)
                .filter(l -> isPrime(l) && isPrime(l + g))
                .filter(l -> LongStream.range(l + 1, l + g).noneMatch(GapInPrimes::isPrime))
                .findFirst().orElse(NOT_FOUND);
        if (candidate == NOT_FOUND)
            return null;
        else {
            long[] ret = new long[2];
            ret[0] = candidate;
            ret[1] = candidate + g;
            return ret;
        }
    }

    private static boolean isPrime(long n) {
        return map.computeIfAbsent(n, GapInPrimes::_isPrime);
    }

    private static boolean _isPrime(long n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        else if (n > 2 && n % 2 == 0) return false;

        long end = (long) (Math.sqrt(n) + 1);

        for (long i = 3; i <= end; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}