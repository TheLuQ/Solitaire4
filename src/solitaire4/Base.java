/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author lkettlex
 */
public class Base extends ImageView {
    private final double CARD_WIDTH = 117;
    private final double CARD_HEIGHT = 169;
    
    public Base(Image img){
        super(img);
        setFitWidth(CARD_WIDTH);
        setFitHeight(CARD_HEIGHT);   
    }
}
