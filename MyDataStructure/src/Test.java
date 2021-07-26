
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.addLast(1);
        arrayList.print();
        arrayList.addFirst(2);
        arrayList.print();
        arrayList.add(0, 5);
        arrayList.print();
        arrayList.remove(1);
        arrayList.print();
        System.out.print(arrayList.getSize());
        System.out.print(arrayList.get(1));
        System.out.print("\n");
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.addLast(1);
        linkedList.print();
        linkedList.add(0, 2);
        linkedList.print();
        linkedList.add(1, 3);
        linkedList.print();
        linkedList.addFirst(4);
        linkedList.addLast(5);
        linkedList.print();
        linkedList.removeFirst();
        linkedList.print();
        linkedList.removeLast();
        linkedList.print();
        System.out.print(linkedList.getSize() + "\n");
        loopArrayQueue<Integer> queue = new loopArrayQueue<Integer>();
        for(int i = 0; i < 20; i++) {
        	queue.enqueue(i);
        	queue.print();
        	if(i % 4 == 1) {
        		queue.dequeue();
        		queue.print();
        	}
        }
	}

}
