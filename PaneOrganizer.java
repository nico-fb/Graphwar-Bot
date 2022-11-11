package GraphWar;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class PaneOrganizer {

    private BorderPane root;
    private Graph graph;
    public PaneOrganizer() {
        this.root = new BorderPane();
        this.root.setOnKeyPressed((KeyEvent e) -> this.handleKeyPress(e));
        this.graph = new Graph(this.root);
    }

    public BorderPane getRoot() {
        return this.root;
    }

    private void handleKeyPress(KeyEvent e) {
        KeyCode keyPressed = e.getCode();
        switch (keyPressed) {
            case ESCAPE:
                System.exit(0);
                break;
            case ENTER:
                this.graph.enterPressed();
                System.exit(0);
                break;
            case DIGIT1:
                this.graph.onePressed();
                System.exit(0);
                break;
            case DIGIT2:
                this.graph.twoPressed();
                System.exit(0);
                break;
            case DIGIT5:
                this.graph.fivePressed();
                System.exit(0);
                break;
            default:
                break;
        }
        e.consume();
    }

}
