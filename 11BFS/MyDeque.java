import java.util.*;

public class MyDeque<T> {

    private final int DEFAULT_SIZE = 10;

    private T[] items;
    private int head;
    private int tail;
    private int size;
    private int[] vals;


    public MyDeque() {
	items = (T[]) (new Object[DEFAULT_SIZE]);
	vals = new int[DEFAULT_SIZE];
	head = 0;
	tail = DEFAULT_SIZE - 1;
	size = 0;
    }

    private int normalize(int n) {
	while (n < items.length) {
	    n += items.length;
	}
	return n % items.length;
    }

    private void resize() {
	int newSize = size;
	if (size == items.length) {
	    newSize = size * 2;
	} else {
	    return;
	}
    
	T[] newArray = (T[]) (new Object[newSize]);
	int[] newVals = new int[newSize];
	int copyCounter = 0;
	if (head <= tail) {
	    for (int i = head; i <= tail; ++i) {
		newArray[copyCounter] = items[i];
		newVals[copyCounter] = vals[i];
		copyCounter++;
	    }
	} else {
	    for (int i = head; i < items.length; ++i) {
		newArray[copyCounter] = items[i];
		newVals[copyCounter] = vals[i];
		copyCounter++;
	    }
	    for (int i = 0; i <= tail; ++i) {
		newArray[copyCounter] = items[i];
		newVals[copyCounter] = vals[i];
		copyCounter++;
	    }
	}
	head = 0;
	tail = size - 1;
	items = newArray;
	vals = newVals;
    }

    public boolean add(T item) {
	addLast(item);
	return true;
    }
    public void add(T item, int priority){
	resize();
	addLast(item);
	vals[tail] = priority;
	size++;
    }

    public void addFirst(T item) {
	resize();
	head = normalize(head - 1);
	items[head] = item;
	size++;
    }

    public void addLast(T item) {
	resize();
	tail = normalize(tail + 1);
	items[tail] = item;
	size++;
    }

    public T getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return items[head];
    }

    public T getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return items[tail];
    }

    public T removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	size--;
	int index = head;
	head = normalize(head + 1);
	return items[index];
    }

    public T removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	size--;
	int index = tail;
	tail = normalize(tail - 1);
	return items[index];
    }
    
    public T removeSmallest(){
	int smallest = vals[head];
	int smallIndex = head;
	if (head <= tail){
	    for (int i = head; i <= tail; i++){
		if (vals[i] < smallest){
		    smallIndex = i;
		    smallest = vals[i];
		}
	    }
	}else{
	    for (int i = 0; i <= tail; i++){
		if (vals[i] < smallest){
		    smallIndex = i;
		    smallest = vals[i];
		}
	    }
	    for (int i = head; i < size; i++){
		if (vals[i] < smallest){
		    smallIndex = i;
		    smallest = vals[i];
		}
	    }
	}
	

	return items[smallIndex];
    }

    public int size() {
	return size;
    }

    public String toString() {
	if (size == 0) {
	    return "[ ]";
	}
	String out = "[ ";
	if (head <= tail) {
	    for (int i = head; i <= tail; ++i) {
		out += items[i] + " ";
	    }
	} else {
	    for (int i = head; i < items.length; ++i) {
		out += items[i] + " ";
	    }
	    for (int i = 0; i <= tail; ++i) {
		out += items[i] + " ";
	    }
	}
	return out + "]";
    }

    public static void main(String[] args) {
	MyDeque<Integer> q = new MyDeque<Integer>();
	q.add(1);
	System.out.println(q + " " + q.size());
	q.add(2);
	System.out.println(q);
	q.addFirst(1);
	System.out.println(q);
	for (int i = 0; i < 10; ++i) {
	    q.addFirst(i);
	    System.out.println(q);
	}
	System.out.println(q.removeFirst() + " " + q);
	System.out.println(q.removeFirst() + " " + q);
	System.out.println(q.removeLast() + " " + q);
	System.out.println(q.getFirst() + " " + q);
	System.out.println(q.getLast() + " " + q);
    }
}
