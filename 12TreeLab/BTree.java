/*========== BTree.java ==========  
  Lab: Complete
  1. TreeNode.java
  2. add()
  3. pre/post/in Order()
  4. getHeight
  5. getLevel
  6. toString
  
  Basic binary tree.
  Uses TreeNode
  Stolen from DW.
  =========================*/

import java.io.*;
import java.util.*;

public class BTree<E> {

    public class TreeNode<E>{
	private E data;
	private TreeNode<E> left, right;

	public TreeNode(){}

	public TreeNode(E stuff){
	    data = stuff;
	    left = null;
	    right = null;
	    height = 0;
	}

	public E getData(){
	    return data;
	}
	public TreeNode getLeft(){
	    return left;
	}
	public TreeNode getRight(){
	    return right;
	}

	public void setData(E stuff){
	    data = stuff;
	}
	public void setLeft(TreeNode l){
	    left = l;
	}
	public void setRight(TreeNode r){
	    right = r;
	}
	public String toString(){
	    return data.toString();
	}

    }

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    public int height;
    
    public Random seed;

    private TreeNode<E> root;

    public BTree() {
	root = null;
	seed = new Random();
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( E d ) { 
	TreeNode<E> D = new TreeNode<E>(d);
	add(root, D);
    }

    private void add(TreeNode<E> curr, E val){
	if (root == null){
	     root = new TreeNode<E>(val);
	     return;
	}else{
	    TreeNode<E> left = curr.getLeft();
	    TreeNode<E> right = curr.getRight();
	    if (left == null || right == null){
		if (left == null && right == null){
		    int rand = seed.nextInt(2);
		    if (rand == 0){
		        curr.setLeft( new TreeNode<E>(val));
			return;
		    }else{
		        curr.setRight( new TreeNode<E>(val));
			return;
		    }
		}
		else if (left == null){
		    curr.setLeft( new TreeNode<E>(val));
		    return;
		}else{
		    curr.setRight( new TreeNode<E>(val));
		    return;
		}
	    }
	    else{
	        if( seed.nextInt(2) == 0){
		    add(curr.getLeft(), val);
		}else{
		    add(curr.getRight(),val);
		}
	    }
	}
	
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<E> curr, TreeNode<E> bn ) {
	if (root == null){
	    root = bn;
	    return;
	}else{
	    TreeNode<E> left = curr.getLeft();
	    TreeNode<E> right = curr.getRight();
	    if (left == null || right == null){
		//if they're both null, choose randomly between the children
		if (left == null && right == null){
		    if (seed.nextInt(2) == 0){
			curr.setLeft(bn);
			height++;
			return;
		    }else{
			curr.setRight(bn);
			height++;
			return;
		    }
		}else if(left == null){
		    curr.setLeft(bn);
		    height++;
		    return;
		}else{
		    curr.setRight(bn);
		    height++;
		    return;
		}
	    }else{ //if neither are null, recurse!
		if (seed.nextInt(2) == 0){
		    add(curr.getLeft(), bn);

		    return;
		}else{
		    add(curr.getRight(), bn);
		    return;
		}
	
	    }
	}
    }
	
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }
    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<E> curr ) {
	//VCC
	if (curr == null)
	    return;
        System.out.print(curr.getData() + " ");
        preOrder(curr.getLeft());
        preOrder(curr.getRight());
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<E> curr ) {
	//CVC
	if (curr == null)
	    return;
        inOrder(curr.getLeft());
	System.out.print(curr.getData() + " ");
	inOrder(curr.getRight());
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder( TreeNode<E> curr ) {
	//CCV
	if (curr == null)
	    return;
	if (curr.getLeft()==null && curr.getRight()==null){
	    System.out.print(curr.getData() + " ");
	    return;
	}
        postOrder(curr.getLeft());
	postOrder(curr.getRight());
	System.out.print(curr.getData() + " ");
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr ) {
        int counter = 0;
        return getHeight(curr, counter);
    }

    public int getHeight(TreeNode<E> curr, int counter){
	if (curr == null){
	    return counter;
	}
        int left = getHeight(curr.getLeft(), counter+1);
	int right = getHeight(curr.getRight(), counter+1);
	if (left > right)
	    return left;
	return right;
	
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
      int level
      int currLevel  
      Returns: A string containing all the elements on the
      given level, ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<E> curr, int level ) {
        if (curr == null)
	    return "";
	if (level == 0)
	    return ""+root.getData();
	if (level == 1)
	    return ""+root.getLeft().getData() +" "+ root.getRight().getData();
	else{
	    if (level == getHeight(root) - getHeight(curr)){
		return ""+curr.getData();
	    }else{
		return ""+getLevel(curr.getLeft(), level) +" "+getLevel(curr.getRight(), level);
	    }
	}
	    
    }
    private String getLevel(int level){
	return getLevel(root, level);
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
      0
      1      2
      3  4   5
      ====================*/
    public String toString() {
	return "";
    }
	

    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 16 ;i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );
	System.out.println( "Level 0: " + t.getLevel(0));
	System.out.println( "Level 1: " + t.getLevel(1));
	System.out.println( "Level 2: " + t.getLevel(2));
	System.out.println( "Level 3: " + t.getLevel(3));
	System.out.println( "Level 4: " + t.getLevel(4));
	System.out.println( t );
    }
}
