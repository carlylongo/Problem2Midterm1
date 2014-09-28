import java.util.Scanner;

public class TuitionCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //scanner object
		System.out.println("Enter Initial Tution Cost");
	    int initial_tution_cost = sc.nextInt();
	    System.out.println("Enter %age growth.eg. for 9% enter 9");
	    int percentage=sc.nextInt();
	    int tution_rate=12342;
	    double total_cost=0;
	    total_cost=total_cost+initial_tution_cost;
	    for(int i=0;i<4;i++)
	    {
	    	total_cost=total_cost+(tution_rate*(Math.pow((double)((100+percentage)/100),(double)i)));//tution rate compounding at the given percentage
	    }
	    System.out.printf("The total cost is %f",total_cost);
	    
		//
	

	}

}