public class MyStack{
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

}
