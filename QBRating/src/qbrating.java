import java.util.Scanner;


public class qbrating {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int td,yards,inter,att;
		float qb,comp;
		
		
		
		System.out.println("Enter Touchdowns(TD)");
	      td = in.nextInt();
	      System.out.println("Enter total yards(Yards)");
	      yards = in.nextInt();
	      System.out.println("Enter Interceptions(INT) ");
	      inter = in.nextInt();
	      System.out.println("Enter completions(COMP)");
	      comp = in.nextFloat();
	      System.out.println("Enter Passes attempted(ATT)");
	      att = in.nextInt();
	      qb = (float) ((8.4*yards + 330*td + 100*comp - 200*inter)/att);
	      System.out.println("QB rating using NCAA formula is " + qb);
	      
}
}