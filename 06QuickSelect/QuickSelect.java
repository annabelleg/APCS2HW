public class QuickSelect{
    static int[] ary;
    public QuickSelect(int[] a){
	ary = a;
    }
    public static void partition( int si, int ei){
	int[] D = new int[ary.length];
	for (int i = 0; i < si; i++){
	    D[i] = ary[i];
	}
	for (int i = ei; i < ary.length; i++){
	    D[i] = ary[i];
	}
	int pivot = ary[si];
	int i = si+1;
	while (si != ei){
	    if (ary[i] < pivot){
		D[si] = ary[i];
		si++;
		i++;
	    }else{
		D[ei] = ary[i];
		ei--;
		i++;
	    }
	
	}
	D[si] =pivot;// ary[si];
        for (int x = 0; x < ary.length; x++){
	    ary[x] = D[x];
	}
    }
    public String toString(){
	String r = "[";
	for (int i = 0; i < ary.length-1; i++){
	    r+=ary[i] + ", ";
	}
        r+=ary[ary.length-1] + "] \n";
	return r;
    }
    public static void main(String[]args){
	int[]a = {5,6,20000,534,4,967665765,11,1,8,-1};
	QuickSelect b = new QuickSelect(a);
        b.partition(0,9);
	System.out.println(b);
    }
}
