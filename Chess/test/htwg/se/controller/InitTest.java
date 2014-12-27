package htwg.se.controller;




import org.junit.Before;
import org.junit.Test;

public class InitTest {

	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("unused")
		Init init = new Init();
	}

	@Test
	public void test() {
		Init.main(null);
	}

}
