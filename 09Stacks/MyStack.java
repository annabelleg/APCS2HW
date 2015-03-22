import java.util.*;

public class MyStack<T>{
    LinkedList<T> stack;
    
    public MyStack(){
	stack = new LinkedList<T>();
    }
    public T pop(){
	return stack.removeLast();
    }
    public T peek(){
	return stack.peekLast();
    }
    public T push(T item){
	stack.add(item);
	return item;
    }
    public String toString(){
	return stack.toString();
    }
    public static void main(String[]args){
	MyStack<Integer> a = new MyStack<Integer>();
	a.push(5);
	a.push(7);
	System.out.println(a);
	System.out.println(a.peek());
	System.out.println(a.pop());
	System.out.println(a.pop());
	System.out.println(a.pop());
	System.out.println(a);
	
    }
}
