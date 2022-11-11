package GraphWar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("GraphWar Cheats");
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(),
                Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scene.setFill(new Color(0,0,0,0.2));
        stage.setScene(scene);
        stage.setOpacity(0.2);
        stage.show();
    }

    public static void main(String[] argv) {
        launch(argv);
    }
}
