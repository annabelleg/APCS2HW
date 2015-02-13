import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    public String name(){
	return "gary.annabelle";
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	int size = board.length;
	//build your knights tour here...
	for (int r=0; r < size; r++){
	    for (int c = 0; c < size; c++){
		ans += board[r][c] + " ";
		if (board[r][c] < 10) ans += " ";
	    }
	    ans += "\n";
	}
	//	return ans;
	return hide +clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
    }

    
    public void solve(){
	solve(0,0);
    }

    public void solve(int startx, int starty){
	solve(startx, starty, 1);
    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	
	if (x >= board.length || y >= board.length || x < 0 || y < 0)
	    return false;
	if (currentMoveNumber == board.length * board.length ){
	    board[x][y] = currentMoveNumber;
	    return true;
	}
	if (board[x][y] == 0){
	    System.out.println(this);
	    wait(10);
	    board[x][y] = currentMoveNumber;
	    if (solve(x+1,y+2,currentMoveNumber+1) ||
		solve(x+2,y+1,currentMoveNumber+1) ||
		solve(x-1,y+2,currentMoveNumber+1) ||
		solve(x-2,y+1,currentMoveNumber+1) ||
		solve(x+1,y-2,currentMoveNumber+1) ||
		solve(x+2,y-1,currentMoveNumber+1) ||
		solve(x-1,y-2,currentMoveNumber+1) ||
		solve(x-2,y-1,currentMoveNumber+1)){
		return true;
	    }
	    board[x][y] = 0;
	}
	return false;
    }
    public boolean isSolved(){
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] == board.length * board.length) return true;
	    }
	}
	return false;
    }

    public static void main(String[]args){
	KnightsTour k = new KnightsTour(3);
	k.solve(0,0);
	System.out.println(k);
	System.out.println(k.isSolved());
    }
}
