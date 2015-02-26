public class NQueens{
    int[][] board;
    int N;

    public NQueens(int size){
	board = new int[size][size];
	N = size;
    }
    public String toString(){
	String s = "";
	for (int r = 0; r <  board.length; r++){
	    for (int c = 0; c <  board.length; c++){
		s += board[r][c] + " ";
	    }
	    s += "\n";
	}
	return s;
    }
    public String  name(){
	return "gary.annabelle";
    }
    public boolean solve(){
	return solve(0,0,0);
    }
    public boolean solve(int x){
	return solve(0,x,0);
    }
    public boolean solve(int x, int y, int num){
	if (x >= N || y >= N || x < 0 || y < 0){
	    return false;
	}
	if (num >= N){
	    board[x][y] = num;
	    return true;
	}
	if (num < N){
	    //vertical
	    for (int r = 0; r < N; r++){
		if (board[r][y] != 0 && r != x) return false;
	    }
	    //horizontal
	    for (int c = 0; c < N; c++){
		if (board[x][c] != 0 && c != y) return false;
	    }
	    //diagonal
	    for (int d = 0; d < N; d++){
		//	if (board[x+d]
		
	    }
	    return false;
	}
	if (board[x][y] == 0){
	    board[x][y] = num;
	    if (solve(x+1, 0, num+1) ||
		solve(x+1, y, num+1) ||
		solve(x, y+1, num+1) ||
		solve(x+1, y+1, num+1)){
		return true;
	    }
	    board[x][y] = 0;
	}
	return false;
    }
    public static void main(String[]args){
	NQueens n = new NQueens(4);
	n.solve();
	System.out.println(n);
    }
}
