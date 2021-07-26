public interface MyList<T> {
	public void add(int index, T object);
	public void addFirst(T object);
	public void addLast(T object);
	public void remove(int index);
	public void removeFirst();
	public void removeLast();
	public T get(int index);
	public T getFirst();
	public T getLast();
	public int getSize();
	public boolean isEmpty();
}
