public class LNode{
    
    private int value;
    private LNode next;

    public LNode getNext(){
	return next;
    }
    public int getValue(){
	return value;
    }
    public void setNext(LNode l){
	next = l;
    }
    public void setValue(int n){
	value = n;
    }
    public String toString(){
	return value;
    }

}
