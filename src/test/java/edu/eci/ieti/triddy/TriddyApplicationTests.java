package edu.eci.ieti.triddy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class TriddyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testmain() {
		try{
			TriddyApplication.main(new String[] {});
		} catch (Exception e){
			fail();
		}
	}
}
