/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author lkettlex
 */
public class Solitaire4 extends Application {
    GameLoop gameLoop  = new GameLoop(this);
    final int PREF_WIDTH = 990;
    final int PREF_HEIGHT = 684;
    private static GridPane root;
    
    @Override
    public void start(Stage primaryStage) {
        root = initGrid();        
        Scene scene = new Scene(root, PREF_WIDTH, PREF_HEIGHT);
        //TEST

        //      
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();    
        
        gameLoop.start();
    }
    
    private GridPane initGrid()
    {
        GridPane grid = new GridPane();
        for (int i = 0; i < 7; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0/7);
            col.setHalignment(HPos.CENTER);
            grid.getColumnConstraints().add(col);
        }
        
        RowConstraints row1 = new RowConstraints();
        row1.setValignment(VPos.CENTER);
        row1.setPercentHeight(33.333333);
        grid.getRowConstraints().add(row1);
        
        RowConstraints row2 = new RowConstraints();
        row2.setValignment(VPos.TOP);
        row2.setPercentHeight(66.666666);
        grid.getRowConstraints().add(row2);
        
        grid.gridLinesVisibleProperty().set(true);
        grid.setStyle("-fx-background-color:green");

//        grid.setHgap(10);

        
        return grid;
    }
    
    public void gameUpdate(){        
        //isMousePressed();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
