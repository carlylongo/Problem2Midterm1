package MainPackage;

import junit.framework.TestCase;

public class testAddTwoNumbers extends TestCase {

	public void testAddTwoNumbers() {
		int total = 8;
		int value1= 4;
		int value2= 4;
		
		int sum = MyClass.AddTwoNumbers(value1, value2);
		assertEquals("Test is passed",sum, total);
	}

}
