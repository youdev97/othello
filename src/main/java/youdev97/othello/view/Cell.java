/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev97.othello.view;

import static youdev97.othello.model.ColorP.BLACK;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import youdev97.othello.model.ColorP;
import youdev97.othello.model.Facade;
import youdev97.othello.model.Position;

/**
 * class that represent the cells of the baord, draw if there's pawn
 * manage action clicks on each one
 * @author Younes
 */
public class Cell extends StackPane {

    public Cell(Facade board, int i, int j) {
        getChildren().clear();
        ColorP c = board.getPieceAt(new Position(i, j)).getColor(); //color of piece on this cell
        ColorP playerClr = board.getCurrentPlayer().getColor(); //color of current player
        Circle circle = new Circle(20);
        Circle player = new Circle(20);
        Rectangle indicator = new Rectangle(60, 60);
        indicator.setFill(Color.LIGHTCORAL);
        switch (c) {
            case WHITE:
                circle.setFill(Color.WHITE);
                getChildren().add(circle);
                break;
            case BLACK:
                circle.setFill(Color.BLACK);
                getChildren().add(circle);
                break;
            case WALL:
                ImageView image = new ImageView(new Image(getClass().getResourceAsStream("Wall.png")));
                image.setFitHeight(60);
                image.setFitWidth(60);
                getChildren().add(image);
//                Rectangle mur = new Rectangle(60, 60);
//                mur.setFill(Color.ORANGE);
//                getChildren().add(mur);
                break;
		default:
			break;
        }
        /*
        if (board.moveList().contains(new Position(i, j))) {
            circle = new Circle(8);
            circle.setFill(Color.LIGHTGREY.darker());
            getChildren().add(circle);
        }
         */
        if (board.isRunning()) {
            if (board.getCurrentPlayer().getColor() == BLACK) {
                addEventFilter(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                    if (e.getButton() == MouseButton.PRIMARY) {
                        board.place(new Position(i, j));
                    } else if (e.getButton() == MouseButton.SECONDARY) {
                        board.placeWall(new Position(i, j));
                    }
                });
                addEventFilter(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                    if (playerClr == BLACK) {
                        player.setFill(Color.BLACK);
                    } else {
                        player.setFill(Color.WHITE);
                    }
                    if (board.moveList().contains(new Position(i, j))) {
                        indicator.setFill(Color.LIMEGREEN);
                    }
                    getChildren().addAll(indicator, player);
                });
                addEventFilter(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                    getChildren().removeAll(player, indicator);
                });
            } else {
                board.getStrategy().iaPlay(board);
            }
        }

    }
}
