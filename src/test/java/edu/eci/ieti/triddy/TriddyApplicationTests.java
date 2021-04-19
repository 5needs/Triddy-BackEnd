package edu.eci.ieti.triddy;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
