package com.example.fredenbe20.uno.Uno;

import android.view.View;

import com.example.fredenbe20.uno.game.GameHumanPlayer;
import com.example.fredenbe20.uno.game.GameMainActivity;
import com.example.fredenbe20.uno.game.infoMsg.GameInfo;

/**
 * Created by fredenbe20 on 3/27/2018.
 */

public class UnoHumanPlayer extends GameHumanPlayer {

    public UnoHumanPlayer(String name){
        super(name);
    }
    @Override
    public void setAsGui(GameMainActivity activity) {

    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }
}
