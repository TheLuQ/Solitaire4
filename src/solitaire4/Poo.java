/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author lkettlex
 */
public class Poo extends Base{
    private ObservableList<Card> pooCards = FXCollections.observableArrayList();
    
    public Poo() {
        super(new Image("file:C:\\Users\\lkettlex\\Pictures\\drop.png"));
    }
        
    public void addCards(List<Card> tempCards){
        Poo oldPoo = tempCards.get(0).getCardPoo();
        if (oldPoo != null)
            oldPoo.removeCards(tempCards);
        pooCards.addAll(tempCards);
        tempCards.forEach(card -> card.setCardPoo(this));
        tempCards.forEach(card -> {
            card.relocate(getLayoutX(),getLayoutY()); // 1. nie wiem czy tutaj, 2. nie wiem czy nie przeniesc do klas potomnych
        });
    }
    
    public void removeCards(List<Card> tempCards){
        pooCards.removeAll(tempCards);
    }
}
