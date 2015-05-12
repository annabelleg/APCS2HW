import java.util.*;
public class MyHeap{
    private ArrayList<Integer> data;
    int size;
    

    public MyHeap(){
	data = new ArrayList<Integer>();
	size = 0;
        data.add(size);
    } 
    public String toString(){
	String result = "";
	for (int i = 1; i < data.size(); i*=2){
	    for (int j = i; j < 2*i; j++){
		result += data.get(j) + " ";
	    }
	    result += "\n";
	}
	return result;
    }

    public int remove(){
	return data.get(1);
    } 
    public void add(int n){
	if (data == null){
	    data.add(n);
	    data.set(0,++size);
	    return;
	}
	if (data.get(0) == 0){
	    data.add(n);
	    data.set(0, ++size);
	    return;
	} else {
	    //   int temp = data.get(0) + 1;
	    data.set(0, ++size);
	    return;
	}
    }
    public int getSize(){
	return size;
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap();
	h.add(4);
	//	System.out.println(h.remove());
	System.out.println(h);
	System.out.println("Size: " + h.getSize());
    }
}
