import java.util.Scanner;


public class Saving {public static void main(String[] args)
{
	Scanner in = new Scanner(System.in);
	int n1,n2;
	float inc,inc2,r1,r2;
	
	
	System.out.println("How many years do you plan to work?");
      n1 = in.nextInt();
      System.out.println("Enter expected average percentage return on investment");
      r1 = in.nextFloat();
      System.out.println("How long do you want to draw? ");
      n2 = in.nextInt();
      System.out.println("Enter expected average percentage return on payback period");
      r2 = in.nextFloat();
      System.out.println("Enter required income(monthly)");
      inc = in.nextFloat();
      System.out.println("Enter SSI(monthly)");
      inc2 = in.nextFloat();
      r2=r2/1200;
      r1=r1/1200;
      
      float v2 = 1/(1+r2);
      float v1 = 1/(1+r1);
      v2=(float)Math.pow(v2,n2*12);
      v1=(float)Math.pow(v1,n1*12);
      float v3 = (float)Math.pow(1+r1,n1*12);
      float p1 = (inc-inc2)*(1-v2)/r2;
      float p2 = (1-v1)*v3/r1;
      
      System.out.println("You must save "+p1/p2 + " each month");
      System.out.println("Total required "+p1);
      
}

}
