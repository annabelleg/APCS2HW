import java.util.Arrays;
public class QuickSelect{

    public static void partition(int[]ary, int si, int ei){
	int[] D = new int[ary.length];
	for (int i = 0; i < si; i++){
	    if (i < si || i > ei){
		D[i] = ary[i];
	    }
	}
	int ri = si + (int)(Math.random()*(ei-si+1));
	int pivot = ary[ri];
	System.out.println("pivot = " + pivot);
	int i = si;
	while (i <= ei){
	    if (ary[i] < pivot){
		D[si] = ary[i];
		si++;
		i++;
	    }else{
		D[ei] = ary[i];
		ei--;
		i++;
	    }
	    System.out.println(Arrays.toString(D));
	}
	D[si] =pivot;

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
