import java.util.*;
import java.io.*;

public class KnightsTour{
	
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
	
    private int[][]board;
	
    public String name(){
	return "gary.annabelle";
    }
	
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
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		ans += board[r][c] + " ";
		if (board[r][c] < 10){
		    ans += ' ';
		}
	    }
	    ans += '\n';
	}
	return ans + "\n";
    }
	
    public KnightsTour(int size){
	board = new int[size][size];
    }
	
    public boolean solve(){
	return solve(0,0);
    }
	
    public boolean solve(int startx, int starty){
	return solve(startx,starty,1);
    }
	
    public boolean solve(int x,int y,int currentMoveNumber){
	if (x<0 ||y<0 || x >= board.length || y >= board.length){
	    return false;
	}
	if (currentMoveNumber == board.length * board.length && board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    return true;
	}
	if (board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if (solve(x+1,y+2,currentMoveNumber + 1) ||
		solve(x+1,y-2,currentMoveNumber + 1) ||
		solve(x-1,y+2,currentMoveNumber + 1) ||
		solve(x-1,y-2,currentMoveNumber + 1) ||
		solve(x+2,y+1,currentMoveNumber + 1) ||
		solve(x+2,y-1,currentMoveNumber + 1) ||
		solve(x-2,y+1,currentMoveNumber + 1) ||
		solve(x-2,y-1,currentMoveNumber + 1)){
		return true;
	    }
	    board[x][y] = 0;
	}
	return false;
    }
	
    public static void main(String[]args){
	KnightsTour t = new KnightsTour(6);
	if(t.solve()){
	    System.out.println(t);
	}else{
	    System.out.println("Cannot solve");
	}
    }
}
