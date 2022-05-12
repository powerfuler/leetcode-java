package others.q02_多线程交替打印;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印 0~100 的奇偶数
 */
public class Solution {
    public static void main(String[] args) {
        new Thread(new PrintMethod(), "偶").start();
        // 确保偶数线程线先获取到锁
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new PrintMethod(), "奇").start();
        System.out.println();
    }

    static int count=0 ;
    static ReentrantLock lock = new ReentrantLock();
    static class PrintMethod implements Runnable{
        @Override
        public void run() {
            while (count <= 100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    lock.notifyAll();
                    if(count <= 100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}