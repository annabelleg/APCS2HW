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
	return solve(0,0,1);
    }
    public boolean solve(int x){
	return solve(x,0,1);
    }
    public boolean solve(int x, int y, int num){
	if (x >= N || y >= N || x < 0 || y < 0){
	    return false;
	}
	if (board[x][y] != 0){
	    return false;
	}
	for (int i = 0; i < N; i++){
	    //vertical
	    if (board[i][y] != 0 && i != x) return false;
	    //horizontal
	    if (board[x][i] != 0 && i != y) return false;
	    //diagonal
	    if (y + i < board.length && x + i < board.length){
		if (board[x+i][y+i] != 0) return false;
	    }
	    if (y + i < board.length && x - i >= 0){
		if (board[x-i][y+i] != 0) return false;
	    }
	    if (y - i  >= 0 && x + i < board.length){
		if (board[x+i][y-i] != 0) return false;
	    }
	    if (y - i >= 0 && x - i >= 0){
		if (board[x-i][y-i] != 0) return false;
	    }
	}
	if (board[x][y] == 0){
	    board[x][y] = num;
	    for (int i = 0; i < N; i++){
		if (solve(i, y+1, num + 1)) return true;
	    }
	    board[x][y] = 0;
	}
	if (num == N){
	    board[x][y] = num;
	    return true;
	}
	return false;
    }

    public static void main(String[]args){
	NQueens a = new NQueens(5);
	System.out.println(a.name());
	System.out.println("NQueens:");
    
	NQueens b = new NQueens(5);
	b.solve();
	System.out.println(b);

	NQueens c = new NQueens(5);
	c.solve(3);
	System.out.println(c);

	NQueens d = new NQueens(6);
	if(d.solve()){
	    System.out.println(d);
	}else{
	    System.out.println("Cannot solve");
	}

	System.out.println("Hi Mr. K!!!");
    }
}
