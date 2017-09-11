package week2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Baiye on 04/09/2017.
 */
public class DequeTest {
    public static void main(String args[]) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        int operate = StdRandom.uniform(2);
        for (int i = 0;i < 100000;i++) {
            int num = StdRandom.uniform(100);
            if (operate == 1) {
                randomizedQueue.enqueue(num);
            } else {
                if (randomizedQueue.isEmpty()) {
                    continue;
                }
                randomizedQueue.dequeue();
            }
        }



     /*   week2.Deque<Integer> deque = new week2.Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);

        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);


        deque.iterator().forEachRemaining(System.out::println);*/
      /*  while (deque.iterator().hasNext()) {
            System.out.println(deque.iterator().next());
        }*/

    }
}
