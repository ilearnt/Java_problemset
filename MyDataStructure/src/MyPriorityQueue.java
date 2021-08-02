import java.util.ArrayList;

public class MyPriorityQueue {
	
	private ArrayList<Integer> heap;
	private int size;
	
	public MyPriorityQueue() {
		// TODO Auto-generated constructor stub
		this.heap = new ArrayList<>();
		heap.add(0);
		this.size = 0;
	}
	
	private int getParent(int pos) {
		return (pos - 1) / 2;
	}
	
	private int getLeftChild(int pos) {
		return pos * 2;
	}
	
	private int getRightChild(int pos) {
		return pos * 2 + 1;
	}
	private void swap(int a, int b) {
		int temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}
	private void heapifyDown() {
		int index = 1;
		while(getLeftChild(index) <= size) {
			int left = getLeftChild(index);
			int smallerNode = left;
			int right = getRightChild(index);
			if(right <= size && heap.get(right) < heap.get(left)) {
				smallerNode = right;
			} 
			if(heap.get(index) < heap.get(smallerNode)) {
				break;
			} else {
				swap(index, smallerNode);
			}
			index = smallerNode;
		}
	}
	private void heapifyUp() {
		int index = size;
		int parent = getParent(size);
		while(parent >= 1 && heap.get(parent) > heap.get(index)) {
			swap(parent, index);
			index = parent;
			parent = getParent(index);
		}
	}
	public int poll() {
		if (size == 0) throw new IndexOutOfBoundsException();
		int num = heap.get(1);
		heap.set(1, heap.get(size));
		size --;
		heapifyDown();
		return num;
	}
	public void add(int num) {
		heap.add(num);
		size ++;
		heapifyUp();
	}
	public int peek() {
		if(size == 0) throw new IndexOutOfBoundsException();
		return heap.get(1);
	}
	public int getSize() {
		return size;
	}
	public void print() {
		for(int num : heap) {
			System.out.print(num);
		}
	}
}
