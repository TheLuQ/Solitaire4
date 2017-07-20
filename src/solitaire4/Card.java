/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import java.util.List;
import javafx.scene.Node;
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
            Base collisionBase;
            List<Node> tempList= getParent()
                    .getChildrenUnmodifiable()
                    .filtered(node -> node instanceof Base 
                            && node.getBoundsInParent().intersects(dropCard.getBoundsInParent())
                            && node != this);
            
            if (!tempList.isEmpty()){
                collisionBase = (Base)tempList.get(0);
                if (collisionBase.test(dropCard.getCards()))
                    collisionBase.addCards(dropCard.getCards());
            }
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
    
    @Override
    public void addCards(List<Card> cards){
        cardPoo.addCards(cards);
    }
    
    @Override
    public boolean test(List<Card> t) {
        return !t.isEmpty();
    }
    
    private List<Card> getCards(){
        return cardPoo.getCards(this);
    }
}
