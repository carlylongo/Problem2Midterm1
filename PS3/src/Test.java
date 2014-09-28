
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InsufficientFundsException {
		
		//creating an instance with id and balance
		Account newac= new Account(1122,20000);
		
		//setting annual interest rate
		newac.setter_aIR(4.5);
		
		//withdrawing from the account
		newac.withdraw(2500);
		
		//depositing in the account
		newac.deposit(3000);
		
		//
	
		
		System.out.println("The account balance is "+newac.getter_bal()+"\nThe monthly interest rate recieved on this account"+newac.monthlyInterestRate()+"\nAccount created at"+newac.getter_date());
		

	}

}