import java.util.Arrays;

public class Sorts{

    public static String name(){
	return "gary.annabelle";
    }

    public static String toString(int[] ary){
	String ans = "[ ";
	for (int i = 0; i < ary.length-1; i++){
	    ans += ary[i] + ", ";
	}
	ans += ary[ary.length-1] + " ]";
	return ans;
    }


    public static int[] heapsort(int[] ary){
        ary = heapify(ary);
        
	return heapsort(ary, ary.length-1);
    }


    public static int[] heapify(int[] ary){
	int[] temp = new int[ary.length];
	for (int i = 0; i < ary.length; i++){
	    temp[i] = ary[i];
	    
	    temp = putInCorrectOrder(temp, i);
	}
	return temp;
    }

    public static int[] putInCorrectOrder(int[] ary, int index){
	if (index > 0){
	    if (ary[index] > ary[ (index/2) ]){ // if child > parent
		int temp = ary[index];
		ary[index] = ary[(index)/2];
		ary[(index/2)] = temp;
        
		putInCorrectOrder(ary, index/2);
			
	    }
	}
	return ary;
    }
    
    public static int[] heapsort(int[] ary, int end){
	if (end != 1){
	    int temp = ary[end];
	    ary[end] = ary[0];
	    ary[0] = temp;
	    pushDownIntoPlace(ary, 0, end);
	    return heapsort(ary, end-1);
	}
	return ary;
	
    }
    
    public static void pushDownIntoPlace(int[]ary, int start, int end){
	if (start == end){
	    return;
	}
	if (ary.length == 3){
	    if (ary[start] < ary[start+1]){
		int temp = ary[start];
		ary[start] =  ary[start+1];
		ary[start+1] =  temp;
	    }
	}
	else if (start*2+1 < end){               
	    int larger = 2*start;
	    if (ary[larger+1] > ary[larger]){
		larger ++;
		}
	    if (ary[start] < ary[larger]){
		int temp = ary[start];
		ary[start] =  ary[larger];
		ary[larger]= temp;
		pushDownIntoPlace(ary, larger, end);
	    } else { return; }
	    
	}
    }
    public static void main(String[]args){
	int[] a = new int[10];
	for (int i = 0; i < 10; i++){
	    a[i] = (int) (Math.random() * 30);
	}
	int[] ary = {4,1,0,6,3,8};
	//	Sorts.heapsort(ary);
	//	System.out.println(name());
	System.out.println(Sorts.toString(Sorts.heapsort(a)));
    }
   
}
