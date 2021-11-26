package others.q02_多线程交替打印.code;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印 0~100 的奇偶数
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        new Thread(new TurningRunner(), "偶数").start();
        // 确保偶数线程线先获取到锁
//        Thread.sleep(1);
        new Thread(new TurningRunner(), "奇数").start();

    }

//    public static void main(String[] args) {
//        for (int i = 1; i <= 100; i++) {
//            new Thread(new TurningRunner(), "线程" + i).start();
//        }
//    }

    static int count;
    static ReentrantLock lock = new ReentrantLock();

    static class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 1000) {
                // 获取锁
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    // 唤醒其他线程
                    lock.notifyAll();
                    try {
                        if (count <= 1000) {
                            // 如果任务还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}