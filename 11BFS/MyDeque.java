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
	tail = defaultsize-1;
	size = 0;
    }
    public int getHead(){
	return head;
    }
    public int getTail(){
	return tail;
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
	head = head - 1;
	items[head] = item;
	size++;
    }

    public void addLast(T item) {
	resize();
	tail = tail + 1;
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
	head = head + 1;
	return items[index];
    }

    public T removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	size--;
	int index = tail;
	tail = tail - 1;
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
	MyDeque<String> a = new MyDeque<String>();
	a.add("Hellow", 1);
	a.add("mdks", 4);
	a.add("woop", 16);
	a.add("meep", -1);
	a.add("i", 10);
	a.add("love", 15);
	/*
	a.add("jacky", 183791);
	a.add("boop", 1);
	a.removeFirst();
	a.removeLast();
	a.add("zoop", 1);
	a.add("poop", 1);
	a.add("scoop", 1);
	a.add("zoop", 1);
	a.removeLast();
	System.out.println(a.removeLast());*/
	
	System.out.println("Deque:"+a);
	System.out.println("Priorities:"+a.toStringPriority());
	System.out.println("head: " + a.getHead() + "\ntail: " + a.getTail() + "\nsize: " + a.size());

    }

}
