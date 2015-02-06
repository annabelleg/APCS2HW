public class Recursion implements hw1{

    public String name(){
	return "Gary,Annabelle";
    }

    public int fact(int n){
	if (n < 0)
	    throw new IllegalArgumentException();
	if (n<=1)
	    return 1;
	return n * fact(n-1);
    }

    public int fib(int n){
	if (n<0)
	    throw new IllegalArgumentException("bad");
	if (n==0)
	    return 0;
	if (n==1)
	    return 1;
	return fib(n-1) + fib(n-2);
	
    }

    public double sqrt(double n){
	return sqrtH(n, 1.0);
    }
    public double sqrtH(double n, double guess){
	if (Math.abs((guess * guess) - n) <= 0.00001)
	    return Math.floor(guess * 100000) / 100000;
	return sqrtH(n, (n / guess + guess) / 2);
    }

}
