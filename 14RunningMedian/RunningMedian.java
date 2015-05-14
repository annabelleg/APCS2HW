public RunningMedian{
    
    private MyHeap large;
    private MyHeap small;
    private double median;

    public RunningMedian(){
	large = new MyHeap(false);
	small = new MyHeap(true);
    }

    public double getMedian(){
	return calculateMedian();
    }
    public double calculateMedian(){
	median = ( large.remove() + small.remove() )/2.0;
	return median;
    }
    public void add(int value){
	if (value > double) large.add(value);
	if (value < double) small.add(value);
    }
    
}
