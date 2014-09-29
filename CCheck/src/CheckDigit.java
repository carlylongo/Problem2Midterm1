import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class CheckDigit {
public static void main(String[] args) {

Scanner input;
String line;


Scanner userInput= new Scanner(System.in);
System.out.println("Enter a credit card number as a long integer: ");	
long ccNum = userInput.nextLong();



if(check(ccNum)){
System.out.println(" *"+(ccNum%10000 )+" is valid");	

}
else
	System.out.println(" *"+(ccNum%10000 )+" is invalid");	
	

}

public static boolean check(long ccNum) {
	int[] cint = new int[16];
	int[] cint2 = new int[16];
	if(Math.floor(Math.log10(ccNum) + 1)==16){
		
		int i=0; long copycc=ccNum;
		do { 
			cint[15-i] = (int) (copycc % 10); 
			cint2[15-i] = cint[15-i];
			copycc/= 10; 
			i++; 
		} while (copycc != 0); 
	
	
	
    int sum = 0;
    int length = 16;
    for (i = 0; i < length; i++) {

      // get digits in reverse order
      int digit = cint[length - i - 1];

      // every 2nd number multiply with 2
      if (i % 2 == 1) {
          digit *= 2;
      }
      sum += digit > 9 ? digit - 9 : digit;
    }
    return sum % 10 == 0;
  }
return false;
}

	 
}


