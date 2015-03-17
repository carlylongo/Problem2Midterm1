package MainPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyClass {

	@Test
	public void test() {
		assertTrue(MyClass.ReturnTrue());
		assertEquals(MyClass.AddTwoNumbers(1, 2),3);
	}
	
}
