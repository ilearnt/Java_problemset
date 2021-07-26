
public class loopArrayQueue<T> {
	
	private T[] data;
	private int front;
	private int tail;
	private int size;
	public loopArrayQueue() {
		// TODO Auto-generated constructor stub
		data = (T[])new Object[10];
		front = 0;
		tail = 0;
		size = 0;
	}
	private void resize(int newCapacity) {
		T[] newData = (T[])new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
	}
	public int getSize() {
		return size;
	} 
	public void enqueue(T object) {
        if((tail + 1) % data.length == front) {
            resize(data.length * 2);
        }
        data[tail] = object;
        tail = (tail + 1) % data.length;
        size++;
    }
	public boolean isEmpty() {
	    return front == tail;
	}
	public T dequeue() {
	    if(isEmpty()) {
	    	throw  new IllegalArgumentException("The queue is empty!");
	    }
	    T value = data[front];
	    data[front] = null;
	    front = (front + 1) % data.length;
	    size--;
	    if(size == data.length / 4 && data.length / 2 != 0) {
	    	resize((data.length / 2));
	    }
	    return value;
	}
	public T getFront() {
	    if(isEmpty()) {
	    	throw  new IllegalArgumentException("The queue is empty!");
	    }
	    return data[front];
	}
	public void print() {
		for(int i = front; i != tail; i = (i + 1) % data.length) {
			System.out.print(data[i] + " ");
		}
		System.out.print("\n");
	}
}
