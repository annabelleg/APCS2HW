import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;
    private int numOfMe;

    public BSTreeNode( T d ) {
 
	data = d;
	left = right = null;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }
    public int getNumOfMe(){
	return numOfMe;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }
    public void addOneOfMe(int n){
	numOfMe+=n;
    }

    public int compareTo(BSTreeNode<T> other) {
	return data.compareTo(other.getData());
    }
    public int compareTo(T value){
	return data.compareTo(value);
    }
 
    public String toString(){
	return ""+data;
    }
}

//add counter for how many times that T value exists
