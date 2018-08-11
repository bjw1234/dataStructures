package queue.data_structures;

import array.data_structures.Array;

public class ArrayQueue<E> implements Queue<E> {
	private Array<E> arr;

	public ArrayQueue() {
		arr = new Array<>();
	}

	public ArrayQueue(int capacity) {
		arr = new Array<>(capacity);
	}

	@Override
	public void enqueue(E e) {
		arr.addLast(e);
	}

	@Override
	public E dequeue() {
		return arr.removeFirst();
	}

	@Override
	public E getFront() {
		return arr.getFirst();
	}

	@Override
	public int getSize() {
		return arr.getSize();
	}

	@Override
	public Boolean isEmpty() {
		return arr.getSize() == 0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Queue: front [ ");
		for (int i = 0; i < getSize(); i++) {
			sb.append(arr.getItem(i));
			if (i < getSize() - 1) {
				sb.append(", ");
			}
		}
		sb.append(" ] tail");
		return sb.toString();
	}
}
