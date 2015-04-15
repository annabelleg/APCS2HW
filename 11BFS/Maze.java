import java.io.*;
import java.util.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private static final String invert =  "[37";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }						
    private static final int DFS = 1;
    private static final int BFS = 0;
    private char[][] maze;
    private int maxx,maxy;
    private int startx,starty;  
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    MyDeque<int[]> frontier, moves;
    
    /** Same constructor as before...*/
    public Maze(String filename){   
	frontier = new MyDeque<int[]>();
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
	int[]a = {startx, starty};
	frontier.add(a);
    }
    public String toString(){//do not do the funky character codes
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return ans;
    }
    public String toString(boolean animate) {//do the funky character codes when animate is true
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return hide+invert+go(0,0)+ans+"\n"+show;	
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    /* public boolean solveBFS(boolean animate){  
	if (animate){ 
	    System.out.println(this.toString(true));
	    wait(5);
	}
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    if (findNextMove(startx,starty)){
		solveBFS(animate, startx, starty);
	    }else{
		return false;
	    }
	}
	return true;
	}*/
    /*  public boolean solveBFS(boolean animate, int x, int y){
	if (maze[x][y] == 'E'){
	    return true;
	}else{
	    int[] f = frontier.removeFirst();
	    int[] l = frontier.getLast();
	    maze[x][y]=' ';
	    if (findNextMove(x,y)){
	        solveBFS(animate, f[0], f[1]);
	    }else{
		return false;
	    }
	}
	return true;
	}*/
  
  
    
    /* public boolean solveBFS(boolean animate, int x, int y){
       if (animate){ 
       System.out.println(this.toString(true));
       wait(5);
       }
       }
       /**Solve the maze using a frontier in a DFS manner. 
       * When animate is true, print the board at each step of the algorithm.
       * Replace spaces with x's as you traverse the maze. 
       */
    /*  public boolean solveDFS(boolean animate){   
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solveDFS(animate, startx,starty);
	}
    }
    public boolean solveDFS(boolean animate, int x, int y){
	if (animate){ 
	    System.out.println(this.toString(true));
	    wait(5);
	}
	if (maze[x][y]=='E'){
	    return true;
	}
	if (maze[x][y]==' '){
	    maze[x][y] = 'X';
	    if (solveDFS(animate,x+1, y) ||
		solveDFS(animate,x, y+1) ||	  
		solveDFS(animate,x-1, y) ||
		solveDFS(animate,x, y-1)){
		return true;
	    }
	    maze[x][y] = '.';
	}
	return false;
	}*/
    public boolean solveBFS(boolean animate){
	return solve(animate, BFS);
    }
    public boolean solveDFS(boolean animate){
	return solve(animate, DFS);
    }
    public boolean solveBFS(){
	return solve(false, BFS);
    }
    public boolean solveDFS(){
	return solve(false, DFS);
    }
    public boolean solve(boolean animate, int mode){
	//check that start is valid
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}
	//get starting point
	int[] z = {startx, starty};
	frontier.add(z);

	boolean solved = false;
	int[] next = new int[2];
	while (!solved && frontier.size() > 0){
	    if (animate && !solved){
		System.out.println(toString(true));
	    }
	    //get next point from beginning of frontier
	    if (mode == BFS){
	        next = frontier.removeFirst();
	    }
	    //get next point from end of frontier
	    if (mode == DFS){
	        next = frontier.removeLast();
	    }
	    //check if its solved
	    if (maze[next[0]][next[1]] == 'E'){
		solved = true;
		//ADD COORDINATES
	    }else{ //if its not solved
		maze[next[0]][next[1]] = 'X';
		for (int[] a : getNeighbors(next[0],next[1])){
		    frontier.addLast(a);
		}
	    }
	}
	return solved;
    }
    public ArrayList<int[]> getNeighbors(int x, int y){
	ArrayList<int[]> blah = new ArrayList<int[]>();
	//	int[] a = new int[2];
	if (maze[x+1][y] == ' '){
	    int[]a = {x+1, y};
	    blah.add(a);
	}else if (maze[x-1][y] == ' '){
	    int[]a = {x-1, y};
	    blah.add(a);
	}else if (maze[x][y+1] == ' '){
	    int[]a = {x, y+1};
	    blah.add(a);
	}else if (maze[x][y-1] == ' '){
	    int[]a = {x, y-1};
	    blah.add(a);
	}
	return blah;
    }
	
    // public void getNextMoves(spot){
    //given a spot, find all possible spots and add them to the frontier
    // }
    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
     
    //instead of doing what i do here, start from startx and starty an go through
    public MyDeque<int[]> solutionCoordinates(){ 
	moves = new MyDeque<int[]>();
	int x = findEnd()[0];
	int y = findEnd()[1];
	moves.addFirst(findEnd());
	while(x != startx && y != starty){
	    int[] next = findPreviousMove(x,y);
	    x = next[0];
	    y = next[1];
	    moves.addFirst(next);
	}
	return moves;
	
    }  
    public int[] findEnd(){
	for (int r = 0; r < maxy; r++){
	    for (int c = 0; c < maxx; c++){
		if (maze[c][r] == 'E'){
		    int[] e = {r,c};
		    return e;
		}
	    }
	}
	return null;
    }
    public int[] findPreviousMove(int x, int y){
	int[] a = new int[2];
	if (maze[x+1][y] == 'X'){
	    a[0] = x+1; a[1] = y;
	    return a;
	}else if (maze[x-1][y] == 'X'){
	    a[0] = x-1; a[1] = y;
	    return a;
	}else if (maze[x][y+1] == 'X'){
	    a[0] = x; a[1] = y+1;
	    return a;
	}else if (maze[x][y-1] == 'X'){
	    a[0] = x; a[1] = y-1;
	    return a;
	}
	return a;
    }
    
    public static void main(String[]args){
	Maze f;
	if(args.length < 1){
	    f = new Maze("data1.dat");
	}else{
	    f = new Maze(args[0]);
	}
	System.out.println(f.clear);
	f.solveDFS(true);
	System.out.println(f.solutionCoordinates());
	
    }


}
