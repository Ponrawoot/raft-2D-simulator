package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Map;
import game.Mission;
import game.Player;
import game.base.Coordinate;

public class StoneTest {
	
	private Player player1;
	private Player player2;
	private Map map;

	@BeforeEach
	public void setUpBeforeEachTest() {
		player1 = new Player("Survival boy");
		player2 = new Player("Survival cat");
		map = new Map();
		
		
	}

	@Test
	public void testConstructor() {
		
	}
}
