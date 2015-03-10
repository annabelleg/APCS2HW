import java.util.Arrays;
public class QuickSelect{

    public static int partition(int[]ary, int si, int ei){
	int[] D = new int[ary.length];
	int ri = si + (int)(Math.random()*(ei-si+1));
	int pivot = ary[ri];
	System.out.println("pivot = " + pivot);
	int end = ei;
	for (int i = si; i <= end; i++){
	    if (ary[i] < pivot){
		D[si] = ary[i];
		si++;
	    }if (ary[i] > pivot){
	        D[ei] = ary[i];
		ei--;
	    }
	    System.out.println(Arrays.toString(D));
	}
        D[si] = pivot;
	return si;
    }
    public static int partitionInPlace(int[]ary, int si, int ei){
	int ri = si + (int)(Math.random()*(ei-si+1));
	int pivot = ary[ri];
	//	System.out.println("pivot = " + pivot);
	int start = si;
	int end = ei;
	int temp1,temp2;
	while (start != end){
	    if (ary[start] == pivot){
		temp1 = ary[start];
		temp2 = ary[start + 1];
		ary[start+1] = temp1;
		ary[start] = temp2;;
	    }
	    if (ary[end] == pivot){
		temp1 = ary[end];
		temp2 = ary[end-1];
		ary[end-1] = temp1;
		ary[end] = temp2;
	    }
	    if (ary[start] > ary[end]){
		temp1 = ary[start];
		temp2 = ary[end];
		ary[end] = temp1;
		ary[start] = temp2;
	    }
	    if (ary[end] > pivot){
		end--;
	    }
	    if (ary[start] < pivot){
		start++;
	    }
	}
	return start;
    }
    public static int quickSelect(int[]a, int n){
	if (n < 0 || n > a.length-1){
	    System.out.println("nope");
	    return -1;
	}
	
	int start = 0;
	int end = a.length-1;
	int currentVal = partitionInPlace(a,start,end);

	while (currentVal != n){
	    if (n > currentVal){
		start = currentVal;
	    }else{
		end = currentVal;
	    }
	    currentVal = partitionInPlace(a,start,end);
	}
	return a[n];
        
    }
    public static void main(String[]args){
	int[]a = {17,9,3,6,1,14,8,4,0,5,2,7,10,16,35};
	System.out.println(quickSelect(a,8));
    
    }
}
