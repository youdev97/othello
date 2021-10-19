package youdev97.othello.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import youdev97.othello.model.Board;
import youdev97.othello.model.ColorP;
import youdev97.othello.model.Facade;
import youdev97.othello.model.Observable;
import youdev97.othello.model.Observer;

public class ScoreGraph extends HBox implements Observer {
    private Facade board;
    private double white;
    private double black;
    private int nbMove;
    private XYChart.Series blackLine = new XYChart.Series();
    private XYChart.Series whiteLine = new XYChart.Series();
    final LineChart<Number, Number> lineChart;
    
    public ScoreGraph(Observable obs) {
        board = (Board) obs;
        
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(64);
        yAxis.setTickUnit(2);
        yAxis.setMinorTickVisible(false);
        
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(32);
        xAxis.setTickUnit(2);
        xAxis.setMinorTickVisible(false);
        
        lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Score Othello");
        
        white = board.cntColor(ColorP.WHITE);
        black = board.cntColor(ColorP.BLACK);
        blackLine.getData().add(new XYChart.Data(0, 2));
        whiteLine.getData().add(new XYChart.Data(0, 2));
        
        lineChart.getData().addAll(blackLine, whiteLine);
        getChildren().add(lineChart);
        obs.registerObserver((Observer) this);        
    }

    @Override
    public void update() {
        getChildren().clear();        
        ++nbMove;
        white = board.cntColor(ColorP.WHITE);
        black = board.cntColor(ColorP.BLACK);
        blackLine.getData().add(new XYChart.Data(nbMove, black));
        whiteLine.getData().add(new XYChart.Data(nbMove, white));
        if(black == 2 && white == 2) { //in case of restart game
            nbMove = 0;
            blackLine.getData().clear();
            whiteLine.getData().clear();
        }
        getChildren().add(lineChart);
    }

}
