public class MyLinkedList{
    LNode head, tail, current;
    int size;

    public MyLinkedList(){
    }
    public MyLinkedList(int v){
	head = new LNode(v);
	size=1;
    }

    public String toString(){
	String r = "[ ";
	current = head;
	while(current!=null){
	    r += " "+current.getValue()+",";
	    current = current.getNext();
	}
	return r.substring(0,r.length()-1) + " ]";
    }

    public boolean add(int value){
	if (head==null){
	    head = new LNode(value);
	    size++;
	    return true;
	}if (tail == null){
	    tail = new LNode(value);
	    head.setNext(tail);
	}else{
	    tail.setNext(new LNode(value));
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    
    public boolean add(int index, int value){
	if (index < 0 || index > this.size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (head==null){
	    add(value);
	}
	if (index == this.size){
	    add(value);
	}
	current = head;
	while (index > 0){
	    current = current.getNext();
	    index--;
	}
	//get val and next node of place you're shifting down
	LNode newVal = new LNode(value);
	LNode temp = current.getNext();
	//set val of index
	current.setNext(newVal);
	//shift values down
	newVal.setNext(temp);
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public int get(int index){
	if (index < 0 || index >= size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (index == 0){
	    return head.getValue();
	}
	if (index == size-1){
	    return tail.getValue();
	}
	current = head;
	while (index > 0){
	    index--;
	    current = current.getNext();
	}
	return current.getValue();
	
    }

    public void set(int index, int value){
	current = head;
	while (index > 0){
	    index--;
	    current = current.getNext();
	}
	current.setValue(value);
    }

    public int remove(int index){
	current = head;
	while (index > 0){
	    index--;
	    current = current.getNext();
	}
	int val = current.getValue();
	LNode next = current.getNext();
	while(next.getNext()!=null){
	    current.setValue(next.getValue());
	    current = next;
	    next = next.getNext();
	}
	current.setValue(next.getValue());
	current.setNext(null);
	return val;
    }
    
    public int indexOf(int value){
	if (head.getValue()==value) return 0;
	current = head;
	int counter = 0;
	while (current.getNext()!=null){
	    current = current.getNext();
	    counter++;
	    if (current.getValue()==value){
		return counter;
	    }
	}
	return -1;
    }


    public static void main(String[]args){
	MyLinkedList l = new MyLinkedList();
	l.add(2);
	/*	l.add(7);
	l.add(4);
	l.add(10);
	l.add(-1);
	l.add(7);*/
	//	l.add(4, 10000);
	//	l.set(4,-999999);
	//	System.out.println(l.remove(4));
	System.out.println(l);
	System.out.println(l.size());
	System.out.println(l.get(0));
	//	System.out.println(l.indexOf(5));
    }
}
