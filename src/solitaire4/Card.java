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
    
    public Card(Image img) {
        super(img);
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
