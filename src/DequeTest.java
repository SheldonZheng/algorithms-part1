/**
 * Created by Baiye on 04/09/2017.
 */
public class DequeTest {
    public static void main(String args[]) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);

        deque.iterator().forEachRemaining((i) ->{
            System.out.println(i);
        });

    }
}
