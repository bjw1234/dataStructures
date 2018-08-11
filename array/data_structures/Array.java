package array.data_structures;

// 泛型数组
public class Array<E> {

	private E[] data;
	private int size;

	// 指定容量的数组
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	// 未指定容量的数组
	public Array() {
		this(10);
	}

	// 获取元素个数
	public int getSize() {
		return size;
	}

	// 获取数组的容量
	public int getCapacity() {
		return data.length;
	}

	// 获取指定下标的元素
	public E getItem(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalAccessError("getItem faild, index < 0 or index >= size.");
		}
		return data[index];
	}

	public E getFirst() {
		return getItem(0);
	}

	public E getLast() {
		return getItem(size - 1);
	}

	// 添加到尾部
	public void addLast(E e) {
		add(size, e);
	}

	// 添加到头部
	public void addFirst(E e) {
		add(0, e);
	}

	// 指定位置添加元素
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalAccessError("Add faild, index < 0 or index > size.");
		}

		if (size == data.length) {
			// 数组扩容
			resizeArr(2 * size);
		}

		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = e;
		size++;
	}

	@SuppressWarnings("unchecked")
	private void resizeArr(int i) {
		E[] newArr = (E[]) new Object[i];
		for (int j = 0; j < size; j++) {
			newArr[j] = data[j];
		}
		data = newArr;
	}

	// 判断是否包含某个元素
	public Boolean isContain(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	// 找某个元素的索引
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	// 删除指定位置上的元素
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalAccessError("remove faild, index illegal.");
		}
		E ret = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;

		// 缩小数组容量
		if (size <= data.length / 4 && data.length / 2 != 0) {
			resizeArr(data.length / 2);
		}

		return ret;
	}

	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size - 1);
	}

	public E removeEle(E e) {
		int index = find(e);
		if (index != -1) {
			return remove(index);
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("size = " + size + ", capacity = " + data.length + "\n");
		sb.append("Array: [ ");
		for (int i = 0; i < size; i++) {
			sb.append(data[i]);
			if (i < size - 1) {
				sb.append(", ");
			}
		}
		sb.append(" ]");

		return sb.toString();
	}
}
