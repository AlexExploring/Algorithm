package multiThread;

import sort.template.Count;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A�̴߳�ӡA
 * B�̴߳�ӡB
 * C�̴߳�ӡC
 *
 * �����ӡABCABCABC... ����ӡ100���ַ�
 */
public class JiaoTiDaYin2 {

    /**
     * 0-A,1-B,2-C
     */
    private static Integer count = 0;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Condition printACondition = reentrantLock.newCondition();
        Condition printBCondition = reentrantLock.newCondition();
        Condition printCCondition = reentrantLock.newCondition();

        Thread t1 = new Thread(new PrintRunner(reentrantLock,printACondition,printBCondition,34,'A'));
        Thread t2 = new Thread(new PrintRunner(reentrantLock,printBCondition,printCCondition,33,'B'));
        Thread t3 = new Thread(new PrintRunner(reentrantLock,printCCondition,printACondition,33,'C'));

        t1.start();
        t2.start();
        t3.start();
    }

    static class PrintRunner implements Runnable {
        private ReentrantLock reentrantLock;

        private Condition curCondition;

        private  Condition nextCondition;

        private Integer count;

        private Character character;

        private Integer index = 0;

        public PrintRunner(ReentrantLock reentrantLock, Condition curCondition, Condition nextCondition, Integer count, Character character) {
            this.reentrantLock = reentrantLock;
            this.curCondition = curCondition;
            this.nextCondition = nextCondition;
            this.count = count;
            this.character = character;
        }

        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                if (index <= count) {
                    System.out.println(character);
                    index++;
                }
                nextCondition.signal();
                try {
                    curCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        }
    }
}
