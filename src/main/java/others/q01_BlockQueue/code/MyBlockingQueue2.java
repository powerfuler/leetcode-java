package others.q01_BlockQueue.code;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用阻塞队列ArrayBlockingQueue实现生产者消费者问题
 * @author user
 *
 */
public class MyBlockingQueue2 {
    
	public final static int queueSize = 10;
	public static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);
	
	public static void main(String[] args) {
		Product2 p = new Product2();
		Consumer2 c = new Consumer2();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}

//生产者
class Product2 implements Runnable{

	@Override
	public void run() {
		product();
	}
	
	public void product() {
		while(true) {
			try{
				MyBlockingQueue2.queue.put(1);
				System.out.println("生产了一头烤猪。烤猪数量：" + MyBlockingQueue2.queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//消费者
class Consumer2 implements Runnable{

	@Override
	public void run() {
		consumer();
	}
	
	private void consumer() {
		while(true) {
			try{
				MyBlockingQueue2.queue.take();
				System.out.println("吃掉了一头烤猪。烤猪数量：" + MyBlockingQueue2.queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}