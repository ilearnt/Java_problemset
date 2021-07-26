import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
	
	private int size;
	private final int DEFAULT_CAPACITY = 10;
	private Object[] elementData;
	public MyArrayList() {
		// TODO Auto-generated constructor stub
		this.elementData = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}
	public void add(int index, T object) {
		checkRangeForAdd(index);
		isCapacityEnough(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = object;
		size ++;
	}
	private void isCapacityEnough(int minCapacity) {
		// TODO Auto-generated method stub
		if (elementData.length < minCapacity)
            grow(minCapacity);
	}
	private void grow(int capacity) {
		// TODO Auto-generated method stub
		int newLength = capacity * 2;
		elementData = Arrays.copyOf(elementData, newLength);
	}
	private void checkRangeForAdd(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("out of boundary");
		}
	}
	@Override
	public void addFirst(T object) {
		add(0, object);
	}
	@Override
	public void addLast(T object) {
		// TODO Auto-generated method stub
		isCapacityEnough(size + 1);
		elementData[size ++] = object;
	}
	private void checkRange(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("out of boundary");
	}
	public void remove(int index) {
		// TODO Auto-generated method stub
		checkRange(index);
		int numMoved = size - index - 1;
		if(numMoved > 0) {
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		elementData[--size] = null;
	}
	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		remove(0);
	}
	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		remove(size - 1);
	}
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		checkRange(index);
		return (T) elementData[index];
	}
	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return (T) elementData[0];
	}
	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return (T) elementData[size - 1];
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.print(elementData[i]);
		}
		System.out.print("\n");
	}
}
