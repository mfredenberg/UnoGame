package com.example.fredenbe20.uno.Uno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fredenbe20.uno.R;
import com.example.fredenbe20.uno.game.Game;
import com.example.fredenbe20.uno.game.GameMainActivity;
import com.example.fredenbe20.uno.game.LocalGame;
import com.example.fredenbe20.uno.game.config.GameConfig;

public class UnoMainActivity extends GameMainActivity {

    @Override
    public GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame() {
        return null;
    }


}
