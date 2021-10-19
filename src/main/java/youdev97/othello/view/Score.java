package youdev97.othello.view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import youdev97.othello.model.Board;
import youdev97.othello.model.ColorP;
import youdev97.othello.model.Facade;
import youdev97.othello.model.Observable;
import youdev97.othello.model.Observer;

/**
 * class that set a visual score
 * 
 * @author Younes
 */
public class Score extends VBox implements Observer {

	private final Label lblScore;
	private final Label scoreBlack;
	private final Label scoreWhite;

	private final Label lblTotal;
	private final Label totalBlack;
	private final Label totalWhite;
	private Facade board;
	private ProgressBar bar;
	private ProgressIndicator indicator;
	private double white;
	private double black;
	private double wall;

	public Score(Observable obs) {

		setPadding(new Insets(12));
		setSpacing(10);
		board = (Board) obs;

		// labels
		lblScore = new Label(" Score: ");
		lblScore.setFont(Font.font("TimesRoman", FontWeight.BLACK, 16));
		lblScore.setTextFill(Color.DARKGRAY);

		scoreBlack = new Label("BLACK = 2");
		scoreBlack.setFont(Font.font("Helvetica", FontWeight.BLACK, 16));
		scoreBlack.setStyle("-fx-border-color: black; -fx-border-width: 3;");
		scoreBlack.setTextFill(Color.BLACK);

		scoreWhite = new Label("WHITE = 2");
		scoreWhite.setFont(Font.font("Helvetica", FontWeight.BLACK, 16));
		scoreWhite.setStyle("-fx-border-color: white; -fx-border-width: 3;");
		scoreWhite.setTextFill(Color.WHITE);
		scoreWhite.setOpacity(0.2);

		// set labels in hbox
		HBox hb = new HBox(10);
		hb.getChildren().addAll(lblScore, scoreBlack, scoreWhite);

		// labels total de prises
		lblTotal = new Label(" Total: ");
		lblTotal.setFont(Font.font("TimesRoman", FontWeight.BLACK, 16));
		lblTotal.setTextFill(Color.DARKGRAY);

		totalBlack = new Label("TOTALBLACK = 0");
		totalBlack.setFont(Font.font("Helvetica", FontWeight.BLACK, 16));
		totalBlack.setStyle("-fx-border-color: black; -fx-border-width: 3;");
		totalBlack.setTextFill(Color.BLACK);

		totalWhite = new Label("TOTALWHITE = 0");
		totalWhite.setFont(Font.font("Helvetica", FontWeight.BLACK, 16));
		totalWhite.setStyle("-fx-border-color: white; -fx-border-width: 3;");
		totalWhite.setTextFill(Color.WHITE);

		HBox total = new HBox(10);
		total.getChildren().addAll(lblTotal, totalBlack, totalWhite);

		white = board.cntColor(ColorP.WHITE);
		black = board.cntColor(ColorP.BLACK);
		wall = board.cntColor(ColorP.WALL);

		bar = new ProgressBar();
		bar.setPrefSize(250, 10);
		bar.setStyle("-fx-accent: black;");
		bar.setProgress(black / (black + white));

		indicator = new ProgressIndicator();
		indicator.setProgress((white + black + wall) / 64);
		indicator.setStyle("-fx-accent: green;");

		getChildren().addAll(hb, bar, indicator, total);
		obs.registerObserver(this);
	}

	/**
	 * update the score
	 */
	@Override
	public void update() {
		totalBlack.setText("TOTALBLACK = " + (int) board.getPosSwitchedB().size());
		totalWhite.setText("TOTALWHITE = " + (int) board.getPosSwitchedW().size());
		white = board.cntColor(ColorP.WHITE);
		black = board.cntColor(ColorP.BLACK);
		wall = board.cntColor(ColorP.WALL);
		scoreBlack.setText("BLACK = " + (int) black);
		scoreWhite.setText("WHITE = " + (int) white);
		switch (board.getCurrentPlayer().getColor()) {
		case WHITE:
			scoreBlack.setOpacity(0.2);
			scoreWhite.setOpacity(1);
			break;
		case BLACK:
			scoreWhite.setOpacity(0.2);
			scoreBlack.setOpacity(1);
			break;
		default:
			break;
		}
		bar.setProgress(black / (black + white));
		indicator.setProgress((white + black + wall) / 64);
		if (!board.isRunning()) {
			String winner = (black > white) ? "BLACK" : "WHITE";
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("End Game");
			alert.setContentText("The Winner is " + winner);
			alert.showAndWait();
		}
	}

}
