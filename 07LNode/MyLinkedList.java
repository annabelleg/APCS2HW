public class MyLinkedList<T>{
    LNode<T> head, tail, current;
    int size;

    public MyLinkedList(){
    }
    public MyLinkedList(T v){
	head = new LNode<T>(v);
	size=1;
    }

    public String name(){
	return "gary.annabelle";
    }

    public int size(){
	return size;
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

    public boolean add(T value){
	if (head==null){
	    head = new LNode<T>(value);
	    size++;
	    return true;
	}if (tail == null){
	    tail = new LNode<T>(value);
	    head.setNext(tail);
	}else{
	    tail.setNext(new LNode<T>(value));
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    
    public void add(int index, T value){
	if (index < 0 || index > this.size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (head==null){
	    add(value);
	}
	if (index == size){
	    add(value);
	}
	current = head;
	while (index > 1){
	    current = current.getNext();
	    index--;
	}
	LNode<T> newVal = new LNode<T>(value);
	LNode<T> temp = current.getNext();
	current.setNext(newVal);
	newVal.setNext(temp);
	size++;
    }

    public T get(int index){
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

    public void set(int index, T value){
	current = head;
	while (index > 0){
	    index--;
	    current = current.getNext();
	}
	current.setValue(value);
    }

    public T remove(int index){
        if (index < 0 || index >= size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (head==null){
	    throw new NullPointerException();
	}
	current = head;
	while (index > 0){
	    current = current.getNext();
	    index--;
	}
	T val = current.getValue();
	LNode<T> temp = current.getNext();
	while (temp.getNext() != null){
	    current.setValue(temp.getValue());
	    current = temp;
	    temp = temp.getNext();  
	}
        current.setValue(temp.getValue());
 	current.setNext(null);
	size--;
	return val;
	
    }
    
    public int indexOf(T value){
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
	MyLinkedList<Integer> l = new MyLinkedList<Integer>();
	l.add(2);
	l.add(7);
	l.add(4);
	l.add(10);
	l.add(-1);
       	System.out.println(l.get(3));
	l.add(7);
	l.add(4, 10000);
	l.set(4,-999999);
	System.out.println(l.remove(6));
	System.out.println(l);
	System.out.println(l.size());
	System.out.println(l.get(0));
	System.out.println(l.indexOf(5));
    }
}
