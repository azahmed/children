package com.azahmed.game.children.util;

import static com.azahmed.game.children.util.Utils.MUST_HAVE_ONE_PLAYER;
import static com.azahmed.game.children.util.Utils.NEGATIVE_REMAINDER;
import static com.azahmed.game.children.util.Utils.determineCorrectIndex;
import static com.azahmed.game.children.util.Utils.hasMinimumNumberOfPlayers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.azahmed.game.children.util.Utils;


/**
 * Testing {@link Utils}
 * @author Asrar
 *
 */
public class UtilsTest {
	
	@Test
	public void determineCorrectIndexThrowsErrorCozRemainderIsLTZero() {
		int remainder = -1;
		int listSize = 10;
		String expected = NEGATIVE_REMAINDER; 
		try {
			determineCorrectIndex(remainder, listSize);
			fail("Should have failed!");
		} catch (Exception e) {
			// Expected
			String actual = e.getMessage();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void determineCorrectIndexThrowsErrorCozListIsEmpty() {
		int remainder = 5;
		int listSize = 0;
		String expected = MUST_HAVE_ONE_PLAYER; 
		try {
			determineCorrectIndex(remainder, listSize);
			fail("Should have failed!");
		} catch (Exception e) {
			// Expected
			String actual = e.getMessage();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testDetermineCorrectIndex() throws Exception {
		int remainder = 0;
		int listSize = 6;
		int expected = 5;
		int actual = determineCorrectIndex(remainder, listSize); 
		String message = String.format("Expected:%s for remainder:%s and listSize:%s got:%s", expected, remainder, listSize, actual);
		assertTrue(message, expected == actual);

		remainder = 1;
		expected = 0;
		actual = determineCorrectIndex(remainder, listSize); 
		message = String.format("Expected:%s for remainder:%s and listSize:%s got:%s", expected, remainder, listSize, actual);
		assertTrue(message, expected == actual);

		remainder = 2;
		expected = 1;
		actual = determineCorrectIndex(remainder, listSize); 
		message = String.format("Expected:%s for remainder:%s and listSize:%s got:%s", expected, remainder, listSize, actual);
		assertTrue(message, expected == actual);

		remainder = 3;
		expected = 2;
		actual = determineCorrectIndex(remainder, listSize); 
		message = String.format("Expected:%s for remainder:%s and listSize:%s got:%s", expected, remainder, listSize, actual);
		assertTrue(message, expected == actual);

		remainder = 4;
		expected = 3;
		actual = determineCorrectIndex(remainder, listSize); 
		message = String.format("Expected:%s for remainder:%s and listSize:%s got:%s", expected, remainder, listSize, actual);
		assertTrue(message, expected == actual);

		remainder = 5;
		expected = 4;
		actual = determineCorrectIndex(remainder, listSize); 
		message = String.format("Expected:%s for remainder:%s and listSize:%s got:%s", expected, remainder, listSize, actual);
		assertTrue(message, expected == actual);
		
	}
	
	@Test
	public void testHasMinimumNumberOfPlayersReturnsFalseCoz0PLayers() {
		int playerSize = 0;
		boolean actual = hasMinimumNumberOfPlayers(playerSize);
		assertFalse("Should have failed coz 0 players!", actual);
	}

	@Test
	public void testHasMinimumNumberOfPlayersReturnsTrue() {
		int playerSize = 1;
		boolean actual = hasMinimumNumberOfPlayers(playerSize);
		assertTrue("Should have passed coz 1 players!", actual);
	}
}
