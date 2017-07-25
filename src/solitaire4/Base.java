/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import java.util.List;
import java.util.function.Predicate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author lkettlex
 */
abstract class Base extends ImageView implements Predicate<List<Card>>{
    private final double CARD_WIDTH = 117;
    private final double CARD_HEIGHT = 169;
    private boolean canAccDrop = true;
    
    public Base(Image img){
        super(img);
        setFitWidth(CARD_WIDTH);
        setFitHeight(CARD_HEIGHT);   
    }
    
    abstract void addCards(List<Card> tempCards);
    
    protected boolean getCanAccDrop(){
        return canAccDrop;
    }
    
    protected void setCanAccDrop(boolean canAccDrop){
        this.canAccDrop = canAccDrop;
    }
}
