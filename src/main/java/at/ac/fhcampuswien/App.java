package at.ac.fhcampuswien;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    //Variables
    protected final static int APP_SIZE = 860;

    //GUI Variables
    protected static Pane root;
    protected static Scene menuScene;
    protected static Button a, b, y, q;

    public static void main(String[] args) { launch(args); }
       //Menu.printMenu();
        //Menu.start();
       @Override
       public void start(Stage primaryStage) {
        primaryStage.setTitle("N E W S A P P");
        //primaryStage.getIcons().add(new Image(getClass().getResource("").toExternalForm()));
        primaryStage.setScene(menuScene);
        primaryStage.setResizable(false);
        primaryStage.show();

        //App.root.getChildren().addAll(App.snake.getSnakeLengthArr());

           //sceneGame = new Scene(layoutGame, GAME_SIZE, GAME_SIZE);
    }
}
        //die App Klasse enthält die main() Funktion und
        // erstellt eine Instanz von Menu.
        // Die Funktion Menu.start() wird aufgerufen.
