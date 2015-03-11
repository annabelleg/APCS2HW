import java.util.Arrays;

public class Sorts{

    public static void quickSort(int[]ary){
	quickSortH(ary, 0, ary.length-1);
    }

    public static void quickSortH(int[] ary, int start, int end){
	if (start >= end){
	    return;
	}
	int pivot = partitionInPlace(ary, start, end);
	quickSortH(ary, start, pivot-1);
	quickSortH(ary, pivot+1, end);
    }

    public static int partitionInPlace(int[]ary, int si, int ei){
	int ri = si + (int)(Math.random()*(ei-si+1));
	int pivot = ary[ri];
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

    public static void main(String[]args){
	int[]a = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
	int[]b = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
	int[]c = {-5,17,9,3,6,1,-7,14,8,4,0,5,2,7,-2,10,16,35};
	int[]d = {-5,17,9,3,6,1,-7,14,8,4,0,5,2,7,-2,10,16,35};
	Sorts.quickSort(a);
	Sorts.quickSort(c);
	Arrays.sort(b);
	Arrays.sort(d);
	if (Arrays.equals(a, b)){
	    System.out.println("True"+ Arrays.toString(a));
	}else{
	    System.out.println("noooooo");
	}
	if (Arrays.equals(c, d)){
	    System.out.println("True"+ Arrays.toString(c));
	}else{
	    System.out.println("noooooo");
	}
    }
}
