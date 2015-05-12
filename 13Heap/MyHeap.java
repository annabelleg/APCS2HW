import java.util.*;
public class MyHeap{
    private ArrayList<Integer> data;
    int size;
    

    public MyHeap(){
	data = new ArrayList<Integer>(8);
	size = 0;
        data.add(size);
    } 
    public String toString(){
	String result = "";
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
	return result;
    }

    public int remove(){
	data.set(0, --size);
	return data.get(1);
	
    } 
    public void add(int n){
	if (data.get(0) == 0){
	    data.set(0, ++size);
	    data.add(n);
	    return;
	} else {
	    data.set(0, ++size);
	    if (size < data.size()){
		data.set(size,n);
	    }else{
		data = resize();
		data.set(size, n);
	    }
	    return;
	}
    }
    public int getSize(){
	return size;
    }
    public ArrayList<Integer> resize(){
	ArrayList<Integer> temp = new ArrayList<Integer>(data.size()*2);
	for (int i = 0; i < data.size(); i++){
	    temp.set(i, data.get(i));
	}
	return temp;
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap();
	h.add(4);
	h.add(6);
	System.out.println(h);
	System.out.println(h.remove());
	System.out.println("Size: " + h.getSize());
    }
}
