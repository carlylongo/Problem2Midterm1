public class Employee extends Person{
	public String office;
	public int salary;
	MyDate hired;
	
	
}

//assumption here that these two classes below are not public. 
//Else these two classes should be in two different .java files
class Faculty extends Employee{
	
}
class Staff extends Employee{
	
}
