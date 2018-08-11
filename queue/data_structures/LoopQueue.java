package queue.data_structures;

public class LoopQueue<E> implements Queue<E> {

	private E[] data;
	private int front, tail;
	private int size;

	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.front = 0;
		this.tail = 0;
		this.size = 0;
	}

	public LoopQueue() {
		this(10);
	}

	// À©ÈÝ
	private void resizeArr(int capacity) {
		@SuppressWarnings("unchecked")
		E[] newData = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public void enqueue(E e) {
		// À©ÈÝ
		if ((tail + 1) % data.length == front) {
			resizeArr(2 * data.length);
		}
		// Ìí¼ÓÔªËØ
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalAccessError("LoopQueue is empty.");
		}
		E e = data[front];
		front = (front + 1) % data.length;
		size--;
		// ËõÈÝ
		if (size <= data.length / 4 && data.length / 2 != 0) {
			resizeArr(data.length / 2);
		}
		return e;
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalAccessError("LoopQueue is empty.");
		}
		return data[front];
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Boolean isEmpty() {
		return this.tail == this.front;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("size = " + size + ", capacity = " + data.length + "\n");
		sb.append("LoopQueue: front [ ");
		// for (int i = front; i != tail; i = (i + 1) % data.length) {
		// sb.append(data[i]);
		// if ((i + 1) % data.length != tail) {
		// sb.append(", ");
		// }
		// }
		for (int i = 0; i < size; i++) {
			int index = (i + front) % data.length;
			sb.append(data[index]);
			if (index + 1 != tail) {
				sb.append(", ");
			}
		}
		sb.append(" ] tail");

		return sb.toString();
	}
}
