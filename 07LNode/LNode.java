public class LNode<T>{
    
    private T value;
    private LNode<T> next;
    
    public LNode(){
    }
    public LNode(T v){
	value = v;
    }
    public LNode(T v, LNode<T> n){
	value = v;
	next = n;
    }

    public LNode<T> getNext(){
	return next;
    }
    public T getValue(){
	return value;
    }
    public void setNext(LNode<T> l){
	next = l;
    }
    public void setValue(T n){
	value = n;
    }
    public String toString(){
	return ""+value;
    }
}
