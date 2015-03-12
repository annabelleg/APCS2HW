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
	LNode next = new LNode(value);
	current.setNext(next);

    }
    /*  public int get(int index);
    public void set(int index,int value);
    public void add(int value, int index);
    public int remove(int index);
    public int size();
    public int indexOf(int value);*/
    public static void main(String[]args){
	MyLinkedList l = new MyLinkedList(3);
	l.add(2);
	System.out.println(l);
    }
}

