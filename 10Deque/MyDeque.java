public class MyDeque<T>{
    T[] data;
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
	T val = data[head];
	head++;
	return val;
    }
    public T removeLast(){
	T val = data[tail];
	tail--;
	return val;
    }

    public T getFirst(){
	return data[head];
    }
    public T getLast(){
	return data[tail];
    }

    public T[] resize(T[] orig){
	T[] larger = new T[orig.length * 2];
    }

}
