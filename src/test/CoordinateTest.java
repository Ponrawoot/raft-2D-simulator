package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import game.base.Coordinate;

public class CoordinateTest {
	
	Coordinate c1, c2, c3, c4, c5;
	
	@Test
	void testIsNextTo() {
		c1 = new Coordinate(1,2);
		c2 = new Coordinate(1,3);
		c3 = new Coordinate(2,2);
		c4 = new Coordinate(0,0);
		c5 = new Coordinate(2,1);
		
		assertEquals(true, c1.isNextTo(c2));
		assertEquals(true, c1.isNextTo(c3));
		assertEquals(false, c1.isNextTo(c4));
		assertEquals(false, c1.isNextTo(c5));
		assertEquals(true, c3.isNextTo(c5));
		assertEquals(false, c1.isNextTo(c1));
	}

}
