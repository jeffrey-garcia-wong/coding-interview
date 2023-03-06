package io.jeffrey.barclays;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h1>Incrementer</h1>
 *
 * The following code below shows the implementation of an incrementor
 * which is not thread-safe, when the execution of the main function
 * finish, the counter variable is expected to be 400.<p/>
 *
 * <pre>
 * {@code
 * public class Incrementer implements Runnable {
 *      static int counter;
 *
 *      public void run() {
 *          for (int i=0; i<400; i++) {
 *              ++counter;
 *          }
 *      }
 *
 *      public static void main(String [] args) throws InterruptedException {
 *          Thread t1 = new Thread(new Incrementer());
 *          Thread t2 = new Thread(new Incrementer());
 *
 *          t1.start();
 *          t2.start();
 *
 *          t1.join();
 *          t2.join();
 *
 *          System.out.println(counter);
 *     }
 * }
 * }
 * </pre>
 *
 * <b>Requirements</b>
 * <ul>
 *     <li>explain whether the counter variable will be same as the expected value</li>
 *     <li>if NOT, provide the reason and recommend the correct solution</li>
 * </ul>
 */
public class Incrementer implements Runnable {
    static int counter;
    Lock lock;
//
    public Incrementer(Lock lock) {
        this.lock = lock;
    }

    public void run() {
        while (counter < 400) {
            try {
                lock.lock();
                if (counter >= 400) return;
                counter += 1;
//                System.out.println(Thread.currentThread().getName() + " " + count);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String [] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(new Incrementer(lock));
        Thread t2 = new Thread(new Incrementer(lock));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        if (counter != 400) throw new RuntimeException("counter's value is invalid");
    }

}
