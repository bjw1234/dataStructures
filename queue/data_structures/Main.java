package queue.data_structures;

/**
 * 比较100万次运算数组队列和循环队列的性能差异
 * 
 * @author 家伟
 *
 */
public class Main {
	public static void main(String[] args) {
		int count = 100000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		long time1 = test(arrayQueue, count);
		System.out.println("ArrayQueue, time = " + time1 / 1000.0 + 's');

		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		long time2 = test(loopQueue, count);
		System.out.println("LoopQueue, time = " + time2 / 1000.0 + 's');
	}

	public static long test(Queue<Integer> queue, int count) {
		long now = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < count; i++) {
			queue.dequeue();
		}
		long end = System.currentTimeMillis();
		return end - now;
	}
}
