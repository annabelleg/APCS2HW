
import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {
    
    public String name(){
	return "gary.annabelle";
    }

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
      BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if (curr == null){
	    return t;
	}else if (t.compareTo(curr) < 0){
	    curr.setLeft(add(curr.getLeft(), t));
	}else if (t.compareTo(curr) == 0){
	    t.addOneOfMe(1);
	}else{
	    curr.setRight(add(curr.getRight(), t));
	}
	return curr;
	
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
      T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/

    //********This code helpfully supplied by Peter Strbik!!! Thank you Peter!!
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	if (curr == null){
	    return curr;
	}
	if (curr.compareTo(c) < 0){
	    curr.setRight(remove(curr.getRight(), c));
	}
	else if (curr.compareTo(c) > 0){
	    curr.setLeft(remove(curr.getLeft(), c));
	}
	else if (!isLeaf(curr)){
	    curr.setData(findMin(curr.getRight()).getData());
	    curr.setRight(remove(curr.getRight(), curr.getData()));
	}
	else{
	    curr = (curr.getLeft() != null) ? curr.getLeft() : curr.getRight();
	}
	return curr;
	    
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    private BSTreeNode<T> findMax(){
	return findMax(root);
    }
    private BSTreeNode<T> findMax(BSTreeNode<T> curr){
	if (curr == null){
	    return null;
	}else if (curr.getRight() == null){
	    return curr;
	}else{
	    return findMax(curr.getRight());
	}
    }

    private BSTreeNode<T> findMin(){
	return findMin(root);
    }
    private BSTreeNode<T> findMin(BSTreeNode<T> curr){
	if (curr == null){
	    return null;
	}
	else if (curr.getLeft() == null){
	    return curr;
	}else{
	    return findMin(curr.getLeft());
	}
    }
    
    /**
     * stolen from: Dennis Yatunin
     * (no not really stolen from, donated by)
     */

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
	}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }

    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.
      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 
		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * 
		       Math.pow(2, height - targetLevel + 1) - 
		       wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
		
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
	return result;
    }

   
    public static void main( String[] args ) {
	BSTree<Integer> a = new BSTree<Integer>();
	/*  for (int i = 0; i < 16; i++){
	    a.add((int) (Math.random()*50));
	    }*/
	a.add(50);
		a.add(30);
		/*	a.add(70);
	a.add(15);
	a.add(85);
	a.add(25);
	a.add(65);
	a.add(100);
	a.add(10);
	a.add(60);
	a.add(40);
	a.add(75);
	a.add(45);
	a.add(35);
	a.add(67);*/
	System.out.println(a + "\n\n\n");
	a.remove(50);
	System.out.println(a);
    }

}
