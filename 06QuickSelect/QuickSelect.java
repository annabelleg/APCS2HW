import java.util.Arrays;
public class QuickSelect{

    public static void partition(int[]ary, int si, int ei){
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

        for (int x = 0; x < ary.length; x++){
	    ary[x] = D[x];
	}

    }
   
  
    public static void main(String[]args){
	int[]a = {9,3,6,1,8,4,0,5,2,7};
        partition(a,0,a.length-1);
	System.out.println(Arrays.toString(a));
	
    }
}
