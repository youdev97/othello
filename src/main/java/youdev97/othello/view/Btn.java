/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev97.othello.view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import youdev97.othello.model.Facade;

/**
 * Set 3 game's button Abandon, Pass, Restart and give them style and action
 * @author youdev97
 */
public class Btn extends HBox {

    Button btnAbandon = new Button("ABANDON");
    Button btnPass = new Button("PASS");
    Button btnRestart = new Button("RESTART");

    public Btn(Facade board) {
        setAlignment(Pos.CENTER);
        setSpacing(5);
        ArrayList<Button> listBtn = new ArrayList<>();
        listBtn.add(btnAbandon);
        listBtn.add(btnPass);
        listBtn.add(btnRestart);

        for (Button b : listBtn) {
            b.setPrefWidth(100);
            b.setStyle("#glass-grey {\n"
                    + "    -fx-background-color: \n"
                    + "        #c3c4c4,\n"
                    + "        linear-gradient(#d6d6d6 50%, white 100%),\n"
                    + "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
                    + "    -fx-background-radius: 30;\n"
                    + "    -fx-background-insets: 0,1,1;\n"
                    + "    -fx-text-fill: black;\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );\n"
                    + "}");
        }
        getChildren().addAll(btnAbandon, btnPass, btnRestart);
        //Handlers
        btnPass.setOnAction((ActionEvent event) -> {
            if (board.isRunning()) {
                board.nextPlayer();
                board.notifyObservers();
            }

        });

        btnAbandon.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) btnAbandon.getScene().getWindow();
            stage.close();
        });

        btnRestart.setOnAction((ActionEvent e) -> {
            board.restart();
        });
    }

}
