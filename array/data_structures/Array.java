package array.data_structures;

// ��������
public class Array<E> {

	private E[] data;
	private int size;

	// ָ������������
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	// δָ������������
	public Array() {
		this(10);
	}

	// ��ȡԪ�ظ���
	public int getSize() {
		return size;
	}

	// ��ȡ���������
	public int getCapacity() {
		return data.length;
	}

	// ��ȡָ���±��Ԫ��
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

	// ��ӵ�β��
	public void addLast(E e) {
		add(size, e);
	}

	// ��ӵ�ͷ��
	public void addFirst(E e) {
		add(0, e);
	}

	// ָ��λ�����Ԫ��
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalAccessError("Add faild, index < 0 or index > size.");
		}

		if (size == data.length) {
			// ��������
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

	// �ж��Ƿ����ĳ��Ԫ��
	public Boolean isContain(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	// ��ĳ��Ԫ�ص�����
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	// ɾ��ָ��λ���ϵ�Ԫ��
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalAccessError("remove faild, index illegal.");
		}
		E ret = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;

		// ��С��������
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
