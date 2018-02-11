package com.azahmed.afl.game.children;

import static com.azahmed.afl.game.children.util.Utils.determineCorrectIndex;
import static com.azahmed.afl.game.children.util.Utils.hasMinimumNumberOfPlayers;

import java.util.ArrayList;
import java.util.List;

public class GameRunner {

	public static void main(final String[] args) throws Exception {
		final int listSize = 6;
		final List<String> children = populateList(listSize);
		final int index = 10;
		int daPercent = 0;
		int childToRemove = 0;
		int startFrom = 10;
		// Check No Of players
		boolean hasMinPlayers = hasMinimumNumberOfPlayers(children.size());
		if (hasMinPlayers) {
			displayGameSnapshot(index, children);
			// Game Loop
			while (children.size() > 1) {
				daPercent = (index + startFrom) % children.size();
				childToRemove = determineCorrectIndex(daPercent, children.size());
				System.out.println("index:" + index + ", size:" + children.size() + ", daPercent:" + daPercent + ", startFrom:" + startFrom
						+ ", childToRemove@:" + children.get(childToRemove));
				children.remove(childToRemove);
				displayGameSnapshot(index, children);
				startFrom = childToRemove;
			}

			// Size == 1 so announce winner
			displayWinner(children);
		} else {
			System.out.println("Not enough players to play!");
		}
	}

	private static void displayWinner(List<String> children) {
		System.out.println("And the winner is :" + children);
	}

	private static void displayGameSnapshot(int index, List<String> children) {
		System.out.println("Index:" + index);
		System.out.println("children.size:" + children.size());
		System.out.println("children:" + children);
	}

	private static List<String> populateList(final int listSize) {
		final List<String> list = new ArrayList<String>();
		final String[] daArray = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };
		for (int i = 0; i < listSize; i++) {
			list.add(daArray[i]);
		}
		return list;
	}
}
