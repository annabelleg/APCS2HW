public class QuickSelect{

    public static void partition(int[]ary, int si, int ei){
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
	D[si] =pivot;
        for (int x = 0; x < ary.length; x++){
	    ary[x] = D[x];
	}
    }

    public static void main(String[]args){
	int[]a = {5,6,20000,534,4,967665765,11,1,8,-1};
        partition(a,0,9);
	System.out.print("[");
	for (int i = 0; i < a.length-1; i++){
	    System.out.print(a[i] + ", ");
	}
	System.out.println(a[a.length-1] + "] \n");
	
    }
}
