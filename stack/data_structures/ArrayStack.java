package stack.data_structures;

import array.data_structures.Array;

public class ArrayStack<E> implements Stack<E> {
	private Array<E> arr;

	public ArrayStack() {
		arr = new Array<>();
	}

	public ArrayStack(int capacity) {
		arr = new Array<>(capacity);
	}

	@Override
	public void push(E e) {
		arr.addLast(e);
	}

	@Override
	public E pop() {
		return arr.removeLast();
	}

	@Override
	public E peek() {
		return arr.getLast();
	}

	@Override
	public Boolean isEmpty() {
		return arr.getSize() == 0;
	}

	@Override
	public Integer getSize() {
		return arr.getSize();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Stack: [ ");
		for (int i = 0; i < getSize(); i++) {
			sb.append(arr.getItem(i));
			if (i < getSize() - 1) {
				sb.append(", ");
			}
		}
		sb.append(" ] top");
		return sb.toString();
	}
}
