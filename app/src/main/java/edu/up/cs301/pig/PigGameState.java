package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by schmedak15 on 10/14/2015.
 */
public class PigGameState extends GameState {
    int id;
    int playerOneScore;
    int playerTwoScore;
    int tempTotal;
    int dieVal;

    public PigGameState()
    {
        id = 0;
        playerOneScore = 0;
        playerTwoScore = 0;
        tempTotal = 0;
        dieVal = 1;
    }
    public PigGameState(PigGameState state1){
        id = state1.getID();
        playerOneScore = state1.getPlayerOneScore();
        playerTwoScore = state1.getPlayerTwoScore();
        tempTotal = state1.getTempTotal();
        dieVal = state1.getDieVal();
    }
    public int getID(){
        return id;
    }
    public int getPlayerOneScore(){
        return playerOneScore;
    }
    public int getPlayerTwoScore(){
        return playerTwoScore;
    }
    public int getTempTotal(){
        return tempTotal;
    }
    public int getDieVal(){
        return dieVal;
    }
    public void hold(){
        if(id == 0){
            playerOneScore+=tempTotal;
            id = 1;
        }
        else if (id == 1){
            playerTwoScore+=tempTotal;
            id = 0;
        }
        tempTotal = 0;
        return;
    }
    public void roll(){
        dieVal = (int)(Math.random()*6+1);
        if(dieVal == 1){
            tempTotal = 0;
            if(id == 1){
                id = 0;
            }
            else{
                id = 1;
            }
            tempTotal = 0;
        }
        else{
            tempTotal+=dieVal;
        }
        return;
    }

}
