/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev97.othello.view;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import youdev97.othello.model.Facade;
import youdev97.othello.model.Observable;
import youdev97.othello.model.Observer;

/**
 *
 * @author Younes
 */
public class BoardFx extends GridPane implements Observer {

    private Facade board;

    public BoardFx(Observable obs) {
        board = (Facade) obs;
        setPrefSize(560, 560);
        //setPadding(new Insets(12));
        for (int column = 0; column < 8; column++) {
            ColumnConstraints columnConstraints = new ColumnConstraints(70);
            getColumnConstraints().add(columnConstraints);
        }

        for (int row = 0; row < 8; row++) {
            RowConstraints rowConstraints = new RowConstraints(70);
            getRowConstraints().add(rowConstraints);
        }

        for (int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                Cell cell = new Cell(board, row, column);
                cell.setStyle("-fx-background-color: green; -fx-border-color: black");
                setConstraints(cell, column, row);
                getChildren().add(cell);
            }
        }
        obs.registerObserver(this);
    }

    /**
     * update the visual board
     */
    @Override
    public void update() {
        getChildren().clear();       
        for (int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                Cell cell = new Cell(board, row, column);
                cell.setStyle("-fx-background-color: green; -fx-border-color: black");
                setConstraints(cell, column, row);
                getChildren().add(cell);
            }
        }
    }
}
