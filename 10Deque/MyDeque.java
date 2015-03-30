public class MyDeque<T>{
    Object[] data;
    int head, tail;

    public MyDeque(){
	data = new Object[10];
	head = 0;
	tail = head;
    }

    public void addFirst(T value){
	if (head+1 != tail && tail+1 != head){
	    if (head != 0 && tail != data.length-1){
		data[head-1] = value;
		head = head-1;
	    }else{
		data[data.length-1] = value;
		head = data.length-1;
	    }
	}else{
	    data = resize(data);
	    addFirst(value);
	}
    }

    public void addLast(T value){
	if (head+1 != tail && tail+1 != head){
	    if (tail != data.length-1 && head != 0){
		data[tail+1] = value;
		tail = tail+1;
	    }else{
		data[0] = value;
		tail = 0;
	    }
	}else{
	    data = resize(data);
	    addFirst(value);
	}
    }

    public T removeFirst(){
	T val = (T)data[head];
	head++;
	return val;
    }
    public T removeLast(){
	T val = (T)data[tail];
	tail--;
	return val;
    }

    public T getFirst(){
	return (T)data[head];
    }
    public T getLast(){
	return (T)data[tail];
    }

    public Object[] resize(Object[] orig){
	Object[] larger = new Object[orig.length * 2];
	int i = 0;
	while (i < larger.length){
	    if (head == 0){
		larger[i] = orig[i];
	    }else{
		for (int h = head; h < orig.length; h++){
		    larger[i] = orig[h];
		}
		for (int t = 0; t <= tail; t++){
		    larger[i] = orig[t];
		}
	    }
	    i++;
	}
	return larger;
    }
    public String toString(){
	if (data.length == 0){
	    return "[ ]";
	}
	String r = "[ ";
	if (head < tail){
	    for (int i = head; i < tail; i++){
		r+=data[i] + " ";
	    }
	}else{
	    for (int h = head; h < data.length; h++){
		r+=data[h] + " ";
	    }
	    for (int t = 0; t <= tail; t++){
		r+=data[t] + " ";
	    }
	}
	r+= "] \nhead = "+ head + "\ntail = " + tail;
	return r;
    }

    public static void main(String[]args){
	MyDeque<Integer> d = new MyDeque<Integer>();
	//	addFirst(2);
	System.out.println(d);
    }

}
