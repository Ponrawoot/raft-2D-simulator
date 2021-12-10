package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.base.Coordinate;

public class CellTest {
	private Cell c1, c2, c3, c4, c5;

	@BeforeEach
	public void setUp() throws Exception {
		Coordinate co1 = new Coordinate(0, 0);
		Coordinate co2 = new Coordinate(0, 1);
		Coordinate co3 = new Coordinate(1, 0);
		Coordinate co4 = new Coordinate(1, 1);
		Coordinate co5 = new Coordinate(0, 0);
		
		c1 = new Cell(co1, true, false, true);
		c2 = new Cell(co2, false, false, true);
		c3 = new Cell(co3, false, true, false);
		c4 = new Cell(co4, true, false, false);
		c5 = new Cell(co5, true, false, true);
	}
	
	@Test
	public void testIsNextTo() {
		assertTrue(c1.isNextTo(c2));
		assertTrue(c2.isNextTo(c1));
		assertTrue(c4.isNextTo(c2));
		assertFalse(c2.isNextTo(c3));
		assertFalse(c1.isNextTo(c4));
		assertFalse(c1.isNextTo(c1));
	}
	
	@Test
	public void testIsSamePosition() {
		assertTrue(c1.isSamePosition(c1));
		assertTrue(c1.isSamePosition(c5));
		assertFalse(c1.isSamePosition(c2));
	}
}
