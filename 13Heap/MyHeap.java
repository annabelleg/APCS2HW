import java.util.*;
public class MyHeap{
    private ArrayList<Integer> data;
    

    public MyHeap(){
	data = new ArrayList<Integer>(1);
	data.set(0, 0);
    } 
    public String toString(){
	String result = "";
	for (int i = 1; i < data.size(); i*=2){
	    for (int j = i; j < 2*i; j++){
		result += data.get(j);
	    }
	}
	return result;
    }

    public int remove(){
	return data.get(0);
    } 
    public void add(int n){
	if (data.size() == 1){
	    data.add(n);
	    data.set(0, 1);
	}
    }
}
