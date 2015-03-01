import java.io.*;
import java.util.*;
public class makelake{
    int[][] data;
    // String stuff = "";
    ArrayList<Integer> stuff = new ArrayList<Integer>();
    public LakeMaking(String s){
	try{
	    Scanner in = new Scanner(new FileReader(s));
	    while (in.hasNext()){
		stuff.add(in.nextInt());
	    }
	}catch (FileNotFoundException e){
	}
    }

    public ArrayList<Integer> Pr(){
	return stuff;
    }

    public void loadData(){
	int i = 4;
	data = new int[stuff.get(0)][stuff.get(1)];
	while (4 < ( ){

	    i++;
	}
    }    
    
    public static void main(String[]args){
	makelake l = new makelake("makelake.txt");
	System.out.println(l.Pr());
    }
}
