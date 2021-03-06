import java.util.*;
public class MyHeap{
    private ArrayList<Integer> data;
    private int size;
    private final boolean MaxOrMin;
    

    public MyHeap(){
	this(true);
    } 

    public MyHeap(boolean isMax)// -> creates a max-heap when boolean is true, min-heap when the boolean is false
    {
	data = new ArrayList<Integer>();
	size = 0;
        data.add(size);
	MaxOrMin = isMax;
	
    }
    public String toString(){
	/*	String result = "";
		int i = 1;
		while (i < data.size()){
		int j = i+1;
		while (j < 2*i+1 && j < size){
		result += data.get(j) + " ";
		j++;
		}
		result += "\n";
		i++;
		}
		return result + "\n";*/
	return data.toString();
       
    }

    
    public int remove(){
	
	int root = data.get(1);
	data.set(1, data.get(size));
	data.remove(size);
	if (size > 2){
	    pushDownIntoPlace(1);
	}
	data.set(0, --size);
	return root;
	
    } 

    public void pushDownIntoPlace(int index){
	if (size == 3){
	    if ((MaxOrMin && data.get(index) < data.get(index+1)) || (!MaxOrMin && data.get(index) > data.get(index+1))){
		int temp = data.get(index);
		data.set(index, data.set(index+1, temp));
	    }
	}
	else if (index*2+1 < size){
	    if (MaxOrMin){                //if max_heap
		int larger = 2*index;
		if (data.get(larger+1) > data.get(larger)){
		    larger ++;
		}
		if (data.get(index) < data.get(larger)){
		    int temp = data.get(index);
		    data.set(index, data.set(larger, temp));
		    pushDownIntoPlace(larger);
		} else { return; }
	    }else{                         //if min_heap
		int smaller = 2*index;
		if (data.get(smaller) > data.get(smaller+1)){
		    smaller ++;
		}
		if (data.get(index) > data.get(smaller)){
		    int temp = data.get(index);
		    data.set(index, data.set(smaller, temp));
		    pushDownIntoPlace(smaller);
		} else { return; }
	    }
	}
    }

    public void add(int n){
	size++;
	data.set(0, size);
	data.add(n);
	if (size > 1){
	    putInCorrectOrder(size);
	}
	return;
    }

    public void putInCorrectOrder(int index){
	if (index>1){
	    if (MaxOrMin){//if it's a max_heap, do this:
		if (data.get(index) > data.get( (index)/2)){ // if child > parent
		    int temp = data.get(index);
		    data.set(index, data.set((index)/2, temp));
        
		    putInCorrectOrder(index/2);
			
		}
	    }else{ //if it's a min_heap, do this:
		if (data.get(index) < data.get( (index)/2)){ // if child < parent
		    int temp = data.get(index);
		    data.set(index, data.set((index)/2, temp));
        
		    putInCorrectOrder(index/2);
			
		}
	    } 
	}
    }

    public int peek(){
	if (data.get(0)>0){
	    return data.get(1);
	}
	throw new NoSuchElementException();
    }

    public int getSize(){
	return size;
    }

    public int getHeight(){
	return (int) (Math.log(size+1)/Math.log(2));
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap(false);
	
	for (int i = 14; i > 0; i--){
	    int toAdd = (int) (Math.random() *100);
	    h.add(toAdd);
	    System.out.println(h);
	    System.out.println("Peek: " +h.peek());
	}
	System.out.println("Size: " + h.getSize());
	System.out.println("Height: " + h.getHeight());
	for (int i = 15; i > 0; i--){
	    System.out.println("Remove: " +h.remove());
	    //    System.out.println("Peek: " +h.peek());
	    System.out.println(h);
	    
	}
	System.out.println("Size: " + h.getSize());
	System.out.println("Height: " + h.getHeight());
    }
}
