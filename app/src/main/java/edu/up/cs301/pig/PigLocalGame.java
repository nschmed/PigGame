package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.PigHoldAction;
import edu.up.cs301.game.actionMsg.PigRollAction;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigLocalGame extends LocalGame {

    PigGameState localGame;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        localGame = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    public boolean canMove(int playerIdx) {
        if(playerIdx == localGame.getID()){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    public boolean makeMove(GameAction action) {
        if(canMove(getPlayerIdx(action.getPlayer()))) {
            if (action instanceof PigRollAction) {
                localGame.roll();
            } else if (action instanceof PigHoldAction) {
                localGame.hold();
            }
            return true;
        }
        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PigGameState(localGame));
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    public String checkIfGameOver() {
        if(localGame.getPlayerOneScore()>=50){
            return "Player One Wins. Congratulations.";
        }
        else if (localGame.getPlayerTwoScore()>=50){
            return "Player Two Wins. Congratulations.";
        }
        return null;
    }

}// class PigLocalGame
