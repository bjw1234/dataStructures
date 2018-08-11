package stack.data_structures;

public interface Stack<E> {
	void push(E e);
	E pop();
	E peek();
	Boolean isEmpty();
	Integer getSize();
}
