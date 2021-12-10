package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.base.Coordinate;

public class CoordinateTest {
	
	Coordinate c0, c1, c2, c3, c4, c5, c6;
	
	@BeforeEach
	public void setUp() throws Exception {
		c0 = new Coordinate();
		c1 = new Coordinate(1,2);
		c2 = new Coordinate(1,3);
		c3 = new Coordinate(2,2);
		c4 = new Coordinate(0,0);
		c5 = new Coordinate(2,1);
		c6 = new Coordinate(-1, -2);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(c0.getX(), 9);
		assertEquals(c0.getY(), 12);
		assertEquals(c1.getX(), 1);
		assertEquals(c1.getY(), 2);
		assertEquals(c6.getX(), 0);
		assertEquals(c6.getY(), 0);
	}
	
	@Test
	public void testIsNextTo() {
		assertEquals(true, c1.isNextTo(c2));
		assertEquals(true, c1.isNextTo(c3));
		assertEquals(false, c1.isNextTo(c4));
		assertEquals(false, c1.isNextTo(c5));
		assertEquals(true, c3.isNextTo(c5));
		assertEquals(false, c1.isNextTo(c1));
	}

}
