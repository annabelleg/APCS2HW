public class RunningMedian{
    
    private MyHeap large;
    private MyHeap small;
    private double median;

    public RunningMedian(){
	large = new MyHeap(false);
	small = new MyHeap(true);
    }

    public String name(){
	return "gary.annabelle";
    }


    public double getMedian(){
	return calculateMedian();
    }
    public double calculateMedian(){
	if (small.getSize() == 0 && large.getSize() == 0){
	    return 0.0;
	}
	if (small.getSize() > large.getSize()){
	    return small.peek() + 0.0;
	}
	if (large.getSize() > small.getSize()){
	    return large.peek() + 0.0;
	}
	return ((small.peek() + large.peek())/2.0);
	
    }
    public void add(int value){
	if (value > median) 
	    large.add(value);
	else
	    small.add(value);
	balance();
    }
    public void balance(){
	int l = large.getSize();
	int s = small.getSize();
	if (Math.abs(l - s) > 1){
	    if (l > s){
		small.add(large.remove());
	    }else{
		large.add(small.remove());
	    }
	}
    }
    public static void main(String[]args){
	RunningMedian r = new RunningMedian();
	System.out.println(r.name());
	System.out.println(r.getMedian());
	r.add(5);
	System.out.println(r.getMedian());
	r.add(12);
	System.out.println(r.getMedian());
	r.add(0);
	System.out.println(r.getMedian());
	r.add(3);
	System.out.println(r.getMedian());
	r.add(4);
	System.out.println(r.getMedian());
    }
}
