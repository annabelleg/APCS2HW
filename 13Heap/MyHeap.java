public class MyHeap{
    private ArrayList<Integer> data;
    

    public MyHeap(){
	data = new ArrayList<Integer>(1);
	data.set(0, 0);
    } 
    public String toString(){
    }
    public int remove(){
    } 
    public void add(int n){
	if (data.size() == 1){
	    data.add(n);
	    data.set(0, 1);
	}
    }
}
