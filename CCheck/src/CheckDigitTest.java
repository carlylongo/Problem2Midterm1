
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;


public class CheckDigitTest {

	@Test
	public void testCheck() {
		
		boolean result = CheckDigit.check(4246345689049834L);
		assertEquals(false, result );
		
		result = CheckDigit.check(4388576018410707L);
		assertEquals(true, result );
		
	}

}