import java.util.Date ;
public class Account 
{
	private int id=0;
	private double balance=0;
	private double annualInterestRate=0;
	private java.util.Date date = new java.util.Date();
	//default constructor
	public Account()
	{
		
	}
	//constructor to create account with id and balance
	public Account(int id , double balance)
	{
		this.id=id;
		this.balance=balance;
	}
	//accessor methods
	public int getter_id(){return id;}
	public double getter_bal(){return balance;}
	public double getter_aIR(){return annualInterestRate;}
	public Date getter_date(){return date;}
	
	//mutator methods
	public void setter_id(int id){this.id=id;}
	public void setter_balance(double balance){this.balance=balance;}
	public void setter_aIR(double annualInterestRate){this.annualInterestRate=annualInterestRate;}
	
	//mothlyInterestRate
	public double monthlyInterestRate(){return annualInterestRate/12;}
	
	//withdraw method
	public void withdraw(double withdrawlAmount)throws InsufficientFundsException
    {
		if(balance>withdrawlAmount)
		{
		balance=balance-withdrawlAmount;
		}
		else
		{
			double needs = withdrawlAmount - balance;
	        throw new InsufficientFundsException(needs);
		}
	}
	
	//deposit method
	public void deposit(double depositAmount){balance=balance+depositAmount;}
	
	
	
	
	
	
	
}