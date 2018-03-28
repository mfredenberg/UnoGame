package com.example.fredenbe20.uno.Uno;

import com.example.fredenbe20.uno.game.GamePlayer;
import com.example.fredenbe20.uno.game.LocalGame;
import com.example.fredenbe20.uno.game.actionMsg.GameAction;

/**
 * Created by fredenbe20 on 3/27/2018.
 */

public class UnoLocalGame extends LocalGame {

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

    }

    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }
}
