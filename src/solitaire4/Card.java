/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

/**
 *
 * @author lkettlex
 */
public class Card extends Base{
    private final SimpleObjectProperty<Poo> cardPoo = new SimpleObjectProperty<>();
    private double xOff, yOff;
    private double shift;
    private static List<Card> dropCards = null;
    private static Poo oldPoo = null;
    
    public Card(Image img) {
        super(img);
        setManaged(false);
        shift = 0;

        cardPoo.addListener((val, oldVal, newVal) -> {
            if (oldVal != null ){
                oldVal.removeCards(Arrays.asList(this));
            }
        });
        
        setOnMousePressed(ev -> {
            xOff = ev.getX();
            yOff = ev.getY();
        });
        
        setOnDragDetected(ev -> {
            startFullDrag();
        });
        
        setOnMouseDragged (ev -> {
            if (dropCards == null){
                dropCards = new ArrayList<>(this.getCards());
                oldPoo = dropCards.get(0).getCardPoo();
                dropCards.forEach(card -> {
                    card.setCardPoo(null);
                    card.toFront();
                });
            }

            dropCards.forEach(card -> {                
                card.relocate(ev.getSceneX() - xOff, ev.getSceneY() - yOff + dropCards.indexOf(card)*shift);
            });
        });

        setOnMouseDragExited(ev -> {
            Base collisionBase = (Base) getParent()
                    .getChildrenUnmodifiable()
                    .filtered(node -> node instanceof Base 
                            && node.getBoundsInParent().intersects(dropCards.get(0).getBoundsInParent())
                            && !dropCards.contains(node)
                            && ((Base)node).getCanAccDrop())
                    .stream()
                    .findFirst().orElse(null);
            
            if (collisionBase != null && (collisionBase.test(dropCards))){
                    collisionBase.addCards(dropCards); 
            }
            else{
                oldPoo.addCards(dropCards);
            }

            dropCards = null;
            oldPoo = null;
        });
    }

    /**
     * @return the cardPoo
     */
    public Poo getCardPoo() {
        return cardPoo.get();
    }

    /**
     * @param cardPoo the cardPoo to set
     */
    public void setCardPoo(Poo cardPoo) {
        this.cardPoo.set(cardPoo);
    }
    
    @Override
    public void addCards(List<Card> cards){
        cardPoo.get().addCards(cards);
    }
    
    @Override
    public boolean test(List<Card> t) {
        return !t.isEmpty();
    }
    
    private List<Card> getCards(){
        return cardPoo.get().getCards(this);
    }

    /**
     * @param shift the shift to set
     */
    public void setShift(double shift) {
        this.shift = shift;
    }
}
