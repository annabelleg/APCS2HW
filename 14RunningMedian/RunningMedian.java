public RunningMedian{
    
    private MyHeap large;
    private MyHeap small;
    private int median;

    public RunningMedian(){
	large = new MyHeap(false);
	small = new MyHeap(true);
    }

    public int getMedian(){
	return calculateMedian();
    }
    public int calculateMedian(){
	median = ( large.remove() + small.remove() )/2;
	return median;
    }
    
}
