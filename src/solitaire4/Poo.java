/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import java.util.List;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author lkettlex
 */
public class Poo extends Base implements Predicate<List<Card>>{
    private ObservableList<Card> pooCards = FXCollections.observableArrayList();
    private double posY;
    private final double SHIFT = 30;
    
    public Poo() {
        super(new Image("file:C:\\Users\\lkettlex\\Pictures\\drop.png"));
        
        pooCards.addListener((ListChangeListener) change -> {
            while (change.next()){
                if (change.wasAdded() || change.wasRemoved())
                    pooCards.forEach(card -> {
                        if (pooCards.indexOf(card) < (pooCards.size()-1))
                            card.setCanAccDrop(false);
                        else
                            card.setCanAccDrop(true);
                    });
            }
        });
    }
        
    @Override
    public void addCards(List<Card> tempCards){
        setCanAccDrop(false);
        posY = pooCards.isEmpty() ? getLayoutY() : pooCards.get(pooCards.size()-1).getLayoutY() + SHIFT;
        pooCards.addAll(tempCards);
        tempCards.forEach(card -> {
            card.setCardPoo(this);
            card.setShift(SHIFT);
        });
        tempCards.forEach(card -> {            
            card.relocate(getLayoutX(),posY);
            posY += SHIFT;
        });
    }
    
    public void removeCards(List<Card> tempCards){
        pooCards.removeAll(tempCards);
        if (pooCards.isEmpty())
            setCanAccDrop(true);
    }
    
    public List<Card> getCards(Card card){
        return pooCards.subList(pooCards.indexOf(card), pooCards.size());
    }

    @Override
    public boolean test(List<Card> t) {
        return !t.isEmpty(); // tymczasowo (kolor, figura, ilosc)
    }
}
