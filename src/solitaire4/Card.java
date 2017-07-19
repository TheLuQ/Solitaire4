/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import javafx.scene.image.Image;

/**
 *
 * @author lkettlex
 */
public class Card extends Base{
    private Poo cardPoo;
    private double xOff, yOff;
    private static Card dropCard = null;
    private static double prevPosX, prevPosY;
    
    public Card(Image img) {
        super(img);
        setManaged(false);
        setOnMousePressed(ev -> {
            xOff = ev.getX();
            yOff = ev.getY();
            prevPosX = getLayoutX();
            prevPosY = getLayoutY();
        });
        
        setOnDragDetected(ev -> {
            startFullDrag();     
            dropCard = this;
        });
        
        setOnMouseDragged (ev -> {
                layoutXProperty().set(ev.getSceneX() - xOff);
                layoutYProperty().set(ev.getSceneY() - yOff);            
        });       
        
        setOnMouseDragExited(ev -> {
            dropCard.relocate(prevPosX, prevPosY);
            if (boundsInParentProperty().get().intersects(dropCard.boundsInParentProperty().get()))
                if (dropCard != this)
                    ;
        });
    }

    /**
     * @return the cardPoo
     */
    public Poo getCardPoo() {
        return cardPoo;
    }

    /**
     * @param cardPoo the cardPoo to set
     */
    public void setCardPoo(Poo cardPoo) {
        this.cardPoo = cardPoo;
    }
    
}
