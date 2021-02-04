import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JavaTest {
	
	final Calculator cal= new Calculator();
	
	//Test's Operators 
	
	@Test
	void testCalculadora() {
		
		assertEquals(cal.evaluatePostFix("2 2 +"),4);
		
		
	}
	
	//Test´s Operators
	
	@Test
	void testOperator() {
		
		assertEquals(cal.validOperator('-'),true);
		
		
	}
	
	

}
