import org.junit.Test;

import student.TestCase;

public class MemmanTest extends TestCase {

	/**
	 * An artificial test to get initial coverage for the
	 * main method. Delete or modify this test.
	 */
	@Test
	public void testMain() {
		Memman dum = new Memman();
		assertNotNull(dum);
		Memman.main(new String[3]);
		assertEquals(systemOut().getHistory(), ""); // check that nothing was printed out
	}

}
