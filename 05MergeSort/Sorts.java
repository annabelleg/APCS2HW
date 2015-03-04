import java.util.*;
public class Sorts{

    public static void bubble(int[]c) {
        boolean swapped = true;                                         
        while (swapped) {
            swapped = false;
            for (int i= 1; i < c.length; i ++) {
                if (c[i-1] > c[i]) {
                    int temp = c[i];
                    c[i] = c[i-1];
                    c[i-1] = temp;
                    swapped = true;
                }
            }                           
        }
    }

    public static void insertion(int[] c){
	int blah;
	int i;  
	for (int j = 1; j < c.length; j++){
	    blah = c[j];
	    for(i = j - 1; (i >= 0) && (c[i] > blah); i--){
		c[i + 1] = c[i];
	    }
	    c[i + 1] = blah;
	}
    }


    public static void selection(int[] c){
	int i, j, first, temp;  
	for (i = c.length - 1; i > 0; i--){
	    first = 0;
	    for(j = 1; j <= i; j ++){
		if (c[j] > c[first])         
		    first = j;
	    }
	    temp = c[first];
	    c[first] = c[i];
	    c[i] = temp; 
	}           
    }
    
    public static boolean isSorted(int[]c){
	for (int i = 1; i < c.length ; i++){
	    if (c[i] < c[i-1]) return false;
	}
	return true;
    }
    

    public static void mergesort(int[] arr){
	mhelp(arr);
    }
    public static void mhelp(int[] arr){
	//base case
	if (arr.length < 2) return;

	//split into two
        int[] a = Arrays.copyOfRange(arr, 0, arr.length/2);
	int[] b = Arrays.copyOfRange(arr, arr.length/2, a.length);

	mhelp(a);
	mhelp(b);

	//merge the two
	int A = 0;
	int B = 0;
	int ARR = 0;
	while (A <= a.length || B <= b.length){
	    if (a[A] <= b[B]){
		arr[ARR] = a[A];
		A++;
		ARR++;
	    }else if (a[A] > b[B]){
		arr[ARR] = b[B];
		B++;
		ARR++;
	    }else if (A == a.length){
		arr[ARR] = b[B];
		B++;
		ARR++;
	    }else{
		arr[ARR] = a[A];
		A++;
		ARR++;
	    }
        }
	
    }

    public static void randomize(int[] a) {
	Random rand = new Random();
	for (int i = 0; i < a.length; ++i) {
	    int randIndex = rand.nextInt(a.length - i) + i;
	    if (randIndex == i) {
		continue;
	    }
	    int tmp = a[i];
	    a[i] = a[randIndex];
	    a[randIndex] = tmp;
	}
    }
    
    public static void main(String[]args){
	int[] a = new int[99999];
	for (int i = 0; i < a.length; ++i) {
	    a[i] = i;
	}

	Sorts.randomize(a);
	int[] b = new int[99999];
	for (int i = 0; i < b.length; ++i) {
	    b[i] = a[i];
	}
	Sorts.mergesort(a);
	Arrays.sort(b);
	if (a.equals(b)){
	    System.out.println("yaaaas");
	}else{
	   System.out.println("nooooo");  
	} 

    }

}
