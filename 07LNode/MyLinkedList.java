public class MyLinkedList{
    LNode head = new LNode();
    LNode current;

    public MyLinkedList(int v){
	head.setValue(v);
	head.setNext(null);
    }

    public String toString(){
	String r = "[";
	current = head;
	while (current.getNext()!=null){
	    r = r +current.getValue() + ",";
	    current = current.getNext();
	}
	r+=current.getValue() + "]";
	return r;
    }
    public void add(int value){
	current = head;
	while (current.getNext()!=null){
	    current = current.getNext();
	}
	current.setValue(value);
	current.setNext(null);

    }
    public static void main(String[]args){
	MyLinkedList l = new MyLinkedList(3);
	l.add(2);
	System.out.println(l);
    }
}

 
