import java.util.*;
import java.io.*;

public class MyDeque<T> {

    private final int defaultsize = 10;

    private T[] items;
    private int head, tail;
    private int size;
    private int[] vals;


    public MyDeque() {
	items = (T[]) (new Object[defaultsize]);
	vals = new int[defaultsize];
	head = 0;
	tail = defaultsize - 1;
	size = 0;
    }
    public int getHead(){
	return head;
    }
    public int getTail(){
	return tail;
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
    public T get(int index){
	if (head < tail){
	    if (index < head || index > tail){
		throw new ArrayIndexOutOfBoundsException();
	    }
	}else{
	    if (index > tail && index < head){
		throw new ArrayIndexOutOfBoundsException();
	    }
	}
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return items[index];
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
	//find smallest value and index
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
	}T toReturn = items[smallIndex];
	//shift everything over to fill gap
	if (smallIndex <= tail){
	    for (int i = smallIndex; i < tail; i++){
		items[i] = items[i+1];
		vals[i] = vals[i+1];
	    }
	    tail = normalize(tail-1);
	}else{
	    for (int i = size-1; i > head; i--){
		items[i] = items[i-1];
		vals[i] = vals[i-1];
	    }
	    head = normalize(head+1);
	}

	return toReturn;
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
	    for (int i = head; i < tail; ++i) {
		out += items[i] + ", ";
	    }
	    out += items[tail];
	} else {
	    for (int i = head; i < items.length; ++i) {
		out += items[i] + ", ";
	    }
	    for (int i = 0; i < tail; ++i) {
		out += items[i] + ", ";
	    }
	    out += items[tail];
	}
	return out + "]";
    }

    public String toStringPriority(){
	if (size == 0) {
	    return "[ ]";
	}
	String out = "[ ";
	if (head <= tail) {
	    for (int i = head; i < tail; ++i) {
		out += vals[i] + ", ";
	    }
	    out += vals[tail];
	} else {
	    for (int i = head; i < vals.length; ++i) {
		out += vals[i] + " ";
	    }
	    for (int i = 0; i < tail; ++i) {
		out += vals[i] + ", ";
	    }
	    out += vals[tail];
	}
	return out + "]";
    
    }

    public static void main(String[]args){

    }

}
