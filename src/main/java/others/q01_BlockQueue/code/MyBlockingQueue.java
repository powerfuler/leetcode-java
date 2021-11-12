package others.q01_BlockQueue.code;

import java.util.PriorityQueue;

/**
 * 使用非阻塞队列PriorityQueue以及notify(),wait()机制实现一个阻塞队列
 * @author user
 *
 */
public class MyBlockingQueue {

    public final static int queueSize = 10;
    public static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Product p = new Product();
        Consumer c = new Consumer();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

//生产者
class Product implements Runnable {

    @Override
    public void run() {
        product();
    }

    public void product() {
        while (true) {
            synchronized (MyBlockingQueue.queue) {
                while (MyBlockingQueue.queue.size() == MyBlockingQueue.queueSize) {
                    try {
                        System.out.println("仓库已经放不下烤猪了，赶快来吃吧。烤猪数量：" + MyBlockingQueue.queueSize);
                        MyBlockingQueue.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        notify();
                    }
                }
                MyBlockingQueue.queue.offer(1);
                System.out.println("我烤了一头猪。烤猪数量：" + MyBlockingQueue.queue.size());
                MyBlockingQueue.queue.notify();
                System.out.println();
            }
        }
    }
}

//消费者
class Consumer implements Runnable {

    @Override
    public void run() {
        consumer();
    }

    private void consumer() {
        while (true) {
            synchronized (MyBlockingQueue.queue) {
                while (MyBlockingQueue.queue.size() == 0) {
                    try {
                        System.out.println("没有烤猪了，赶快生产一个。烤猪数量：" + MyBlockingQueue.queue.size());
                        MyBlockingQueue.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        notify();
                    }
                }
                MyBlockingQueue.queue.poll();
                System.out.println("吃掉了一头烤猪。烤猪数量：" + MyBlockingQueue.queue.size());
                MyBlockingQueue.queue.notify();
            }
        }
    }

}