import java.util.*;
public class MyHeap{
    private ArrayList<Integer> data;
    private int size;
    private boolean MaxOrMin;
    

    public MyHeap(){
	data = new ArrayList<Integer>(8);
	size = 0;
        data.add(size);
    } 

    public MyHeap(boolean isMax)// -> creates a max-heap when boolean is true, min-heap when the boolean is false
    {
	super();
	MaxOrMin = isMax;
	
    }
    public String toString(){
	/*	String result = "";
	int i = 1;
	while (i < data.size()){
	    int j = i;
	    while (j < 2*i){
		result += data.get(j) + " ";
		j++;
	    }
	    result += "\n";
	    i++;
	}
	return result;*/
	return data.toString();
    }

    public int remove(){
	data.set(0, --size);
	return data.get(1);
	
    } 
    public void add(int n){
	size++;
	data.set(0, size);
	data.add(n);
	if (size > 1){
	    putInCorrectOrder(isMax);
	}
	return;
    }
    public int getSize(){
	return size;
    }
    public void putInCorrectOrder(boolean maxormin){
	if (maxormin){//if it's a max_heap, do this
	    
    }
    public int peek(){
	if (data.get(0)>0){
	    return data.get(1);
	}
	throw new IndexOutOfBoundsException();
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap();
	h.add(4);
	h.add(6);
	System.out.println(h);
	//System.out.println(h.remove());
	System.out.println("Size: " + h.getSize());
    }
}
