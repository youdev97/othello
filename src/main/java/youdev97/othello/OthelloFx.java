package youdev97.othello;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import youdev97.othello.model.Board;
import youdev97.othello.model.Facade;
import youdev97.othello.model.Observable;
import youdev97.othello.view.BoardFx;
import youdev97.othello.view.Btn;
import youdev97.othello.view.Score;
import youdev97.othello.view.ScoreGraph;

public class OthelloFx extends Application {

    private Facade board;
    private BoardFx view;
    private Score score;
    private ScoreGraph graph;

    private Btn btnPanel;
    private final VBox leftView = new VBox(10);

    @Override
    public void start(Stage primaryStage) {
        
        board = new Board();
        score = new Score((Observable) board);
        view = new BoardFx((Observable) board);
        graph = new ScoreGraph((Observable) board);

        btnPanel = new Btn(board);
        leftView.getChildren().addAll(view, btnPanel);

        VBox scoreChart = new VBox();
        scoreChart.getChildren().addAll(score,graph);
        HBox all = new HBox(20);
        all.getChildren().addAll(leftView,scoreChart);
        
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #DCDCDC;");
        root.getChildren().addAll(all);
        
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Othello");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
