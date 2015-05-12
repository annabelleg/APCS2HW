import java.util.*;
public class MyHeap{
    private ArrayList<Integer> data;
    private int size;
    private boolean MaxOrMin;
    

    public MyHeap(){
	this(true);
    } 

    public MyHeap(boolean isMax)// -> creates a max-heap when boolean is true, min-heap when the boolean is false
    {
	data = new ArrayList<Integer>(8);
	size = 0;
        data.add(size);
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
	    putInCorrectOrder(MaxOrMin, size);
	}
	return;
    }
    public int getSize(){
	return size;
    }
    public void putInCorrectOrder(boolean maxormin, int index){
	if (maxormin){//if it's a max_heap, do this
	    if (data.get(index) > data.get( (index)/2)){ // if child > parent
		int temp = data.get(index);
		data.set(index, data.set((index)/2, temp));
		if (index/4 != 0){
		    putInCorrectOrder(MaxOrMin, index/2);
		}
	    }
	}else{
	    if (data.get(index) < data.get( (index)/2)){ // if child > parent
		int temp = data.get(index);
		data.set(index, data.set((index)/2, temp));
		if (index/4 != 0){
		    putInCorrectOrder(MaxOrMin, index/2);
		}
	    }
	} 
    }
    public int peek(){
	if (data.get(0)>0){
	    return data.get(1);
	}
	throw new IndexOutOfBoundsException();
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap(false);
	h.add(4);
	h.add(6);
	h.add(3);
	h.add(8);
	System.out.println(h);
	//System.out.println(h.remove());
	System.out.println("Size: " + h.getSize());
    }
}
