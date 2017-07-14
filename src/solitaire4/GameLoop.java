/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;

/**
 *
 * @author Lukas
 */
public class GameLoop extends AnimationTimer{    
    
    public Timeline animation;
    private final Solitaire4 game;
    
    public GameLoop(Solitaire4 game){
        this.game = game;
    }
    @Override
    public void handle(long now) {
        animation = new Timeline(now);
        game.gameUpdate();
    }
    
}
