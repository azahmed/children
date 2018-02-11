package com.azahmed.game.children.util;

public class Utils {
	public static final int MIN_PLAYERS_REQUIRED = 1;
	public static final String NEGATIVE_REMAINDER = "Negative remainder!";
	public static final String MUST_HAVE_ONE_PLAYER = "Must have 1 player!";

	/**
	 * Use this to get the appropriate index value for the remainder
	 * If remainder == 0, the its the last element in the list
	 * 
	 * @param remainder
	 * @param listSize
	 * @return
	 * @throws Exception 
	 */
    public static int determineCorrectIndex(final int remainder, final int listSize) throws Exception {
    	// Sanity check, should never get this
    	if (remainder < 0) {
    		throw new Exception(NEGATIVE_REMAINDER);
    	}
    	if (listSize <= 0) {
    		throw new Exception(MUST_HAVE_ONE_PLAYER);
    	}
    	
        if (remainder > 0) {
            return remainder - 1;
        } else {
            return listSize - 1;
        }
    }
    
    /**
     * Must have atleast 1 player.
     * 
     * @param playerSize
     * @return
     */
    public static boolean hasMinimumNumberOfPlayers(int playerSize) {
    	if (playerSize >= MIN_PLAYERS_REQUIRED) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
