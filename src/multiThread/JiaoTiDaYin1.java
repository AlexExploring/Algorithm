package multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A线程打印A
 * B线程打印B
 * C线程打印C
 *
 * 交替打印ABCABCABC... 共打印100个字符
 */
public class JiaoTiDaYin1 {

    /**
     * 0-A,1-B,2-C
     */
    private static Integer count = 0;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Condition printACondition = reentrantLock.newCondition();
        Condition printBCondition = reentrantLock.newCondition();
        Condition printCCondition = reentrantLock.newCondition();

        Thread t1 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                if (count + 1 <= 100) {
                    System.out.println("A");
                    count++;
                }
                printBCondition.signal();
                try {
                    printACondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                if (count + 1 <= 100) {
                    System.out.println("B");
                    count++;
                }
                printCCondition.signal();
                try {
                    printBCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                if (count + 1 <= 100) {
                    System.out.println("C");
                    count++;
                }
                printACondition.signal();
                try {
                    printCCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
