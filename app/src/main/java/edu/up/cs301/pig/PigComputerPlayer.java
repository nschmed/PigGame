package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.PigHoldAction;
import edu.up.cs301.game.actionMsg.PigRollAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    PigGameState game;
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof PigGameState) {
            game = (PigGameState) info;
            if (Math.random() > 0.5) {
                PigHoldAction holdAction = new PigHoldAction(this);
                super.game.sendAction(holdAction);
            } else {
                PigRollAction rollAction = new PigRollAction(this);
                super.game.sendAction(rollAction);
            }
        }
    }//receiveInfo

}
