package multiThread;

/**
 * A线程打印A
 * B线程打印B
 * C线程打印C
 *
 * 交替打印ABCABCABC... 共打印100个字符
 */
public class JiaoTiDaYin {

    /**
     * 0-A,1-B,2-C
     */
    private static Integer state = 0;

    private static Object lock = new Object();

    private static Integer count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count + 1 <= 100 && state == 0) {
                        System.out.println("A");
                        lock.notifyAll();
                        count++;
                        state = 1;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count + 1 <= 100 && state == 1) {
                        System.out.println("B");
                        lock.notifyAll();
                        count++;
                        state = 2;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count + 1 <= 100 && state == 2) {
                        System.out.println("C");
                        lock.notifyAll();
                        count++;
                        state = 0;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
