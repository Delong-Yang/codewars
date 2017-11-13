import java.util.PriorityQueue;

// https://www.codewars.com/kata/hamming-numbers/

public class Hamming {

    public static long hamming(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        Long least = 1L;
        for (int i = 0; i < n; i++) {
            least = queue.poll();
            while (least.equals(queue.peek()))
                queue.poll();
            enqueue(queue, least);
        }
        return least;
    }

    private static void enqueue(PriorityQueue<Long> q, long i) {
        q.offer(2 * i);
        q.offer(3 * i);
        q.offer(5 * i);
    }

    public static void main(String[] args) {
        System.out.println(hamming(7));
    }

}