public class MyStack<T>{
    private MyLinkedList<T> stack;

    public MyStack(){
	stack = new MyLinkedList<T>();
    }
    public T push(T item){
	stack.add(item);
	return item;
    }
    public T peek(){
	return stack.tail.getValue();
    }
    public T pop(){
	return stack.remove(stack.size()-1);
    }
    public String toString(){
	return stack.toString();
    }
    public static void main(String[]args){
	MyStack<Integer> a = new MyStack<Integer>();
	a.push(2);
	a.push(4);
	a.push(6);
	a.push(8);
	System.out.println(a.pop());
	System.out.println(a);
    }
}
