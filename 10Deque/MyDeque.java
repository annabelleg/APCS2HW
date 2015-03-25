public class MyDeque<T>{
    Object[] data;
    int head, tail;

    public void addFirst(T value){
	if (head+1 != tail && tail+1 != head){
	    //do something
	}else{
	    data = resize(data);
	    addFirst(value);
	}
    }

    public void addLast(T value){
	if (head+1 != tail && tail+1 != head){
	    //do something
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

}
