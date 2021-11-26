package others.q01_BlockQueue.code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java实现阻塞队列
 *
 */
public class BlockQueue<T> {

    private int size;
    private Object[] queue;

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    private int index;
    private int removeIndex;
    private int currLen;

    public BlockQueue() {
        this(10);
    }

    public BlockQueue(int size) {
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
        this.size = size;
        queue = new Object[size];
    }

    public void push(T element) throws InterruptedException {
        lock.lock();
        try {
            while (currLen == size) {
                System.out.println("队列满。。。");
                full.await();
            }
            System.out.println("添加数据 ：" + element);
            queue[index] = element;
            if (++index == size) {
                index = 0;
            }
            currLen++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T pop() throws InterruptedException {
        lock.lock();
        try {
            while (currLen == 0) {
                System.out.println("队列空。。。");
                empty.await();
            }
            Object obj = queue[removeIndex];
            System.out.println("取出数据 ：" + obj);
            if (++removeIndex == size) {
                removeIndex = 0;
            }
            currLen--;
            full.signal();
            return (T) obj;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> queue = new BlockQueue<Integer>(4);
        queue.push(5);

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("线程1添加");
                    queue.push(11);
                    queue.push(12);
                    queue.push(13);
                    queue.push(14);
                    queue.push(15);
                    queue.push(16);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        new Thread(() -> {
//            try {
//                System.out.println("线程2添加");
//                queue.push(21);
//                queue.push(22);
//                queue.push(23);
//                queue.push(24);
//                queue.push(25);
//                queue.push(26);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("线程1 取出");
                    queue.pop();
                    Thread.sleep(1);
                    queue.pop();
                    queue.pop();
                    queue.pop();
                    queue.pop();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        new Thread(() -> {
//            try {
//                System.out.println("线程2 取出");
//                queue.pop();
//                Thread.sleep(1);
//                queue.pop();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

    }

}