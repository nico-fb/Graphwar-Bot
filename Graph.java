package GraphWar;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Graph {

    private ArrayList<Double> mouseXLocs;
    private ArrayList<Double> mouseYLocs;
    private Pane graphPane;
    private String equation;
    public Graph(Pane graphPane){
        this.graphPane = graphPane;
        Rectangle graph = new Rectangle(Constants.GRAPH_X,
                Constants.GRAPH_Y,
                Constants.GRAPH_WIDTH,
                Constants.GRAPH_HEIGHT);
        graph.setFill(new Color(1, 0, 0, 1));
        graph.setFocusTraversable(true);
        this.graphPane.getChildren().add(graph);

        this.mouseXLocs = new ArrayList<>();
        this.mouseYLocs = new ArrayList<>();

        graphPane.setOnMousePressed((MouseEvent e) ->
                this.addMouseClick(e.getX(), e.getY()));
    }

    private void addMouseClick(Double x, Double y){
        this.mouseXLocs.add(x);
        this.mouseYLocs.add(y);
    }

    public void enterPressed(){
        this.changeToCoordinates();
        this.initialEquationEnter();
        this.restOfEquation();
        System.out.println(equation);
    }
    public void onePressed(){
        this.changeToCoordinates();
        this.initialEquationOne();
        this.restOfEquation();
        System.out.println(equation);
    }
    public void twoPressed(){
        this.changeToCoordinates();
        this.initialEquationTwo();
        this.restOfEquation();
        System.out.println(equation);
    }
    public void fivePressed(){
        this.changeToCoordinates();
        this.initialEquationFive();
        this.restOfEquation();
        System.out.println(equation);
    }

    private void changeToCoordinates(){
        for (int i = 0; i < this.mouseXLocs.size(); i++) {
            this.mouseXLocs.set(i, this.xChanger(this.mouseXLocs.get(i)));
            this.mouseYLocs.set(i, this.yChanger(this.mouseYLocs.get(i)));
        }
    }

    private Double xChanger(Double x){
        DecimalFormat df = new DecimalFormat("#.#");
        Double newX = -((x-Constants.GRAPH_X)/(Constants.GRAPH_WIDTH/50) - 25);
        newX = newX + 0.7;
        newX = Double.valueOf(df.format(newX));
        return newX;
    }
    private Double yChanger(Double y){
        DecimalFormat df = new DecimalFormat("#.#");
        Double newY = -((y-Constants.GRAPH_Y)/(15.4) - 15);
        newY = Double.valueOf(df.format(newY));
        return newY;
    }
    private void initialEquationEnter(){
        Double x = this.mouseXLocs.get(0);
        Double y = this.mouseYLocs.get(1) - this.mouseYLocs.get(0);
        DecimalFormat df = new DecimalFormat("#.#");
        x = Double.valueOf(df.format(x));
        y = Double.valueOf(df.format(y));
        this.equation = "0";
    }
    private void initialEquationOne(){
        Double x = this.mouseXLocs.get(0);
        Double y = this.mouseYLocs.get(1) - this.mouseYLocs.get(0);
        DecimalFormat df = new DecimalFormat("#.#");
        x = Double.valueOf(df.format(x));
        y = Double.valueOf(df.format(y));
        this.equation = "(.1sin(8x))/(1+e^(-100*(x+" + x + ")))";
    }
    private void initialEquationTwo(){
        Double x = this.mouseXLocs.get(0);
        Double y = this.mouseYLocs.get(1) - this.mouseYLocs.get(0);
        DecimalFormat df = new DecimalFormat("#.#");
        x = Double.valueOf(df.format(x));
        y = Double.valueOf(df.format(y));
        this.equation = "(.2sin(8x))/(1+e^(-100*(x+" + x + ")))";
    }
    private void initialEquationFive(){
        Double x = this.mouseXLocs.get(0);
        Double y = this.mouseYLocs.get(1) - this.mouseYLocs.get(0);
        DecimalFormat df = new DecimalFormat("#.#");
        x = Double.valueOf(df.format(x));
        y = Double.valueOf(df.format(y));
        this.equation = "(.5sin(8x))/(1+e^(-100*(x+" + x + ")))";
    }
    private void restOfEquation(){
        for (int i=1; i<this.mouseXLocs.size()/2; i++){
            Double x = this.mouseXLocs.get(2*i);
            Double y = this.mouseYLocs.get(2*i+1) - this.mouseYLocs.get(2*i-1);
            DecimalFormat df = new DecimalFormat("#.#");
            x = x * 0.97;
            x = Double.valueOf(df.format(x));
            y = Double.valueOf(df.format(y));
            this.equation = this.equation + "+(" + y + ")/(1+e^(-100*(x+" + x + ")))";
        }
    }

}
