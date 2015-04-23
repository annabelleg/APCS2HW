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
	    return ""+data;
	}

    }

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
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
	TreeNode<E> D = new TreeNode(d);
	add(root, D);
    }

    private void add(TreeNode<E> curr, E val){
	if (curr == null){
	    curr = new TreeNode<E>(val);
	}else{
	    TreeNode<E> left = curr.getLeft();
	    TreeNode<E> right = curr.getRight();
	    if (left == null || right == null){
		if (left == null && right == null){
		    int rand = seed.nextInt(2);
		    if (rand == 0){
			left.setData(val);
		    }else{
			right.setData(val);
		    }
		}
		else if (left == null){
		    left.setData(val);
		}else{
		    right.setData(val);
		}
	    }
	    else{
		int rand = seed.nextInt(2);
		if (rand == 0){
		    left.setData(val);
		}else{
		    right.setData(val);
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
	if (curr == null){
	    curr = bn;
	}else{
	    TreeNode<E> left = curr.getLeft();
	    TreeNode<E> right = curr.getRight();
	    if (left == null || right == null){
		//if they're both null, choose randomly between the children
		if (left == null && right == null){
		    if (seed.nextInt(2) == 0){
			curr.setLeft(bn);
		    }else{
			curr.setRight(bn);
		    }
		}else if(left == null){
		    curr.setLeft(bn);
		}else{
		    curr.setRight(bn);
		}
	    }else{ //if neither are null, recurse!
		if (seed.nextInt(2) == 0){
		    add(left, bn);
		}else{
		    add(right, bn);
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
    public String preOrder( TreeNode<E> curr ) {
	//VCC
	String s = "";
	if (curr == null)
	    return s;
	s+=curr.getData() + " ";
	s+=preOrder(curr.getLeft()) + " ";
	s+=preOrder(curr.getLeft()) + " ";
	return s;
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public String inOrder( TreeNode<E> curr ) {
	//CVC
	String s = "";
	if (curr == null)
	    return s;
	s+=inOrder(curr.getLeft())+" ";
	s+=curr.getData() + " ";
	s+=inOrder(curr.getLeft()) + " ";
	return s;
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public String postOrder( TreeNode<E> curr ) {
	//CCV
	String s = "";
	if (curr == null)
	    return s;
	s+=postOrder(curr.getLeft()) + " ";
	s+=postOrder(curr.getLeft()) + " ";
	s+=curr.getData() + " ";
	return s;
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
        int left = getHeight(curr.getLeft(), counter);
	int right = getHeight(curr.getRight(), counter);
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
    private String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	return "";
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

	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );
	
	System.out.println( t );
    }
}
