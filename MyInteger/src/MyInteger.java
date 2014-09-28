
public class MyInteger {

	int a;
	
	MyInteger(int num)
	{
		a=num;
	}

	public int getA() {
		return a;
	}

	public boolean isEven()
	{
		if(a/2==0)
			return true;
		else
			return false;
	}
	public boolean isOdd()
	{
		if(a/2==0)
			return false;
		else
			return true;
	}
	
	public boolean isPrime()
	{
		if(a==2){ //for case num=2, function returns true. d
		      return(true);
		    }
		    for(int i=2;i<=(int)Math.sqrt(a)+1;i++){ //loops through 2 to sqrt(num). efficient
		      if(a%i==0){ //if a divisor is found, its not prime. returns false
		        return(false);
		      }
		    }
		    return(true); //if all cases don't divide num, it is prime.
		  
	}
	
	static boolean isEven(int num)
{
	if(num/2==0)
		return true;
	else
		return false;
}
	static boolean isOdd(int a)
{
	if(a/2==0)
		return false;
	else
		return true;
}

	static boolean isPrime(int a)
{
	if(a==2){ //for case num=2, function returns true. 
	      return(true);
	    }
	    for(int i=2;i<=(int)Math.sqrt(a)+1;i++){ //loops through 2 to sqrt(num).  efficient
	      if(a%i==0){ //if a divisor is found, its not prime. returns false
	        return(false);
	      }
	    }
	    return(true); //if all cases don't divide num, it is prime.
	 
}

static boolean isEven(MyInteger num)
{
	if(num.a/2==0)
		return true;
	else
		return false;
}
static boolean isOdd(MyInteger num)
{
	if(num.a/2==0)
		return false;
	else
		return true;
}

static boolean isPrime(MyInteger num)
{
	if(num.a==2){ //for case num=2, function returns true.
	      return(true);
	    }
	    for(int i=2;i<=(int)Math.sqrt(num.a)+1;i++){ //loops through 2 to sqrt(num). efficient
	      if(num.a%i==0){ //if a divisor is found, its not prime. returns false
	        return(false);
	      }
	    }
	    return(true); //if all cases don't divide num, it is prime.
	  }

	
public boolean equals(int b)
{
	if(this.a==b)
		return true;
	else return false;
}
public boolean equals(MyInteger b)
{
	if(this.a==b.a)
		return true;
	else return false;
}

static int parseInt(String a) 
{
	return parseInt(a);
}

static int parseInt(char[] a) 
{
	return parseInt(a);
}


public static void main(String[] args)
{

	MyInteger a = new MyInteger(5);
	System.out.println(a.getA());
	
	
}

}