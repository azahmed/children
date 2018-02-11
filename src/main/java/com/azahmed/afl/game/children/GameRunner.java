package com.azahmed.afl.game.children;

import static com.azahmed.afl.game.children.util.Utils.determineCorrectIndex;
import static com.azahmed.afl.game.children.util.Utils.hasMinimumNumberOfPlayers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

	static int noOfChildren;
	static int index = 10;
	static boolean debugEnabled = false;
	static int startFrom = 10;

	public static void main(final String[] args) throws Exception {
		int daPercent = 0;
		int childToRemove = 0;
		int startingId = 0;
		captureNoOfChildren();
		final List<String> children = populateList(noOfChildren, startingId);
		// Check No Of players
		boolean hasMinPlayers = hasMinimumNumberOfPlayers(children.size());
		if (hasMinPlayers) {
			displayGameParams(index, children);
			// Game Loop
			while (children.size() > 1) {
				daPercent = (index + startFrom) % children.size();
				childToRemove = determineCorrectIndex(daPercent, children.size());
				displayGameIteration(daPercent, childToRemove, children);
				children.remove(childToRemove);
				displayGameSnapshot(index, children);
				startFrom = childToRemove;
			}

			// Size == 1 so announce winner
			displayWinner(children);
		} else {
			System.out.println("Not enough players to play! Good bye");
		}
	}

	private static void displayGameIteration(int daPercent, int childToRemove, final List<String> children) {
		if (debugEnabled) {
			System.out.println("index:" + index + ", size:" + children.size() + ", daPercent:" + daPercent
					+ ", startFrom:" + startFrom + ", childToRemove@:" + children.get(childToRemove));
		} else {
			System.out.println("Removing child:" + children.get(childToRemove));
		}
	}

	/**
	 * Capture number of children from keyboard.
	 * 
	 * @return
	 */
	private static void captureNoOfChildren() {
		Scanner scanner = null;
		try {
			System.out.println("Enter number of children n:");
			scanner = new Scanner(System.in);
			noOfChildren = scanner.nextInt();

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	private static void displayWinner(List<String> children) {
		System.out.println("And the winner is :" + children);
	}

	private static void displayGameSnapshot(int index, List<String> children) {
		if (debugEnabled) {
			System.out.println("Index:" + index + ", startFrom:" + startFrom);
			System.out.println("children.size:" + children.size());
			System.out.println("children:" + children);
		}
	}

	private static void displayGameParams(int index, List<String> children) {
		System.out.println("==============================");
		System.out.println("...Game parameters....");
		System.out.println("Number of children:" + children.size());
		System.out.println("The Children:" + children);
		System.out.println("Starting with child:" + startFrom);
		System.out.println("K:" + index);
		System.out.println("==============================");
	}
	
	private static List<String> populateList(final int listSize, final int startingId) {
		final List<String> list = new ArrayList<String>();
		if (debugEnabled) {
			// Easier to see students as A, B, C instead of 10, 11, 12
			final String[] daArray = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
					"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
			for (int i = 0; i < listSize; i++) {
				list.add(daArray[i]);
			}
		} else {
			// Use actual integer values
			for (int i = 0; i < listSize; i++) {
				list.add(String.valueOf(startingId + i));
			}
		}
		return list;
	}
}
