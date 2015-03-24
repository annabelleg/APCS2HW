import java.util.*;
public class MyQueue<T>{
    private MyLinkedList<T> queue;
    public MyQueue(){
	queue = new MyLinkedList<T>();
    }
    public boolean enqueue(T val){
	queue.add(val);
	return true;
    }
    public T dequeue(){
	if (queue.size()==0){
	    throw new NoSuchElementException();
	}
	return queue.remove();
    }
    public String toString(){
	return queue.toString();
    }
    public static void main(String[]args){
	MyQueue<Integer> a = new MyQueue<Integer>();
	a.enqueue(2);
	a.enqueue(3);
	a.enqueue(4);
	a.enqueue(5);
	System.out.println(a);
	a.dequeue();
	a.dequeue();
	a.dequeue();
	a.dequeue();
	//	a.dequeue();
	System.out.println(a);
    }
}
