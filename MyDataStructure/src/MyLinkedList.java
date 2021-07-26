public class MyLinkedList<T> implements MyList<T>{
	private static class Node<T> {
		T item;
		Node<T> prev;
		Node<T> next;
		public Node(T item, Node<T> next, Node<T> prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	
	private int size;
	
	private Node<T> first;
	
	private Node<T> last;

	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		this.size = 0;
		this.first = null;
		this.last = first;
	}

	@Override
	public void add(int index, T object) {
		// TODO Auto-generated method stub
		checkRange(index);
        if (index == size) {
            addLast(object);
        } else {
            Node<T> l = getNode(index);
            addBeforeNode(object, l);
        }
	}

	private void addBeforeNode(T object, Node<T> node) {
        Node<T> preNode = node.prev;
        Node<T> newNode = new Node<>(object, node, preNode);
        if (preNode == null) {
            first = newNode;
        } else {
            preNode.next = newNode;
        }
        node.prev = newNode;
        size++;
    }
	public void addFirst(T object) {
		// TODO Auto-generated method stub
		add(0, object);
	}
	@Override
	public void addLast(T object) {
		// TODO Auto-generated method stub
		Node<T> l = last;
		Node<T> node = new Node<T>(object, null, l);
		if(l == null) { 
			first = node;
		} else {
			l.next  = node;
		}
		last = node;
		size ++;
	}
	private void checkRange(int index) {
		if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("out of boundary");
		}
	}
	private Node<T> getNode(int index) {
		checkRange(index);
		Node<T> cursor = first;
		for(int i = 0; i < index; i++) {
			cursor = cursor.next;
		}
		return cursor;
	}
	private void deleteLink(int index) {
		Node<T> l = getNode(index);
	    Node<T> prevNode = l.prev;
	    Node<T> nextNode = l.next;
	    if (prevNode == null) {
	    	first = nextNode;
	    } else {
	        prevNode.next = nextNode;
	    }
	    if (nextNode == null) {
	        last = prevNode;
	    } else {
	        nextNode.prev = prevNode;
	        l.prev = null;
	    }
	    size--;
	    l = null;
	}
	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		 checkRange(index);
	     deleteLink(index);
	}

	@Override
	public void removeFirst() {
		if(size == 0)
			return ;
		// TODO Auto-generated method stub
		Node<T> nextNode = first.next;
		if(nextNode == null) {
			first = null;
			last = first;
		} else {
			first = nextNode;
			nextNode.prev = null;
		}
		size --;
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		if(size == 0)
			return ;
		Node<T> prevNode = last.prev;
		if(prevNode == null) {
			last = null;
			first = null;
		} else {
			last = prevNode;
			prevNode.next = null;
		}
		size --;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return getNode(index).item;
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return (first == null) ? null : first.item;
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return (last == null) ? null : last.item;
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
		Node<T> node = first;
		while(node != null) {
			System.out.print(node.item);
			node = node.next;
		}
		System.out.print("\n");
	}
}
