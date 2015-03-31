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
    
    /** Same constructor as before...*/
    public Maze(String filename){   
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
	}
    }
    public String toString(){//do not do the funky character codes
	
    }
    public String toString(boolean animate) {//do the funky character codes when animate is true
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return hide()+invert()+go(0,0)+ans+"\n"+show();	
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){    }

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
}
