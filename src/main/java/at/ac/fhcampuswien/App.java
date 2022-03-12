package at.ac.fhcampuswien;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.*;

public class App extends Application {
    //Variables
    protected final static int APP_HEIGHT = 750;
    protected final static int APP_WIDTH = 1000;

    public static void main(String[] args) { launch(args); }

       @Override
       public void start(Stage primaryStage) {

        primaryStage.setTitle("N E W S A P P");
        primaryStage.getIcons().add(new Image(getClass().getResource("/NewsAppLogo.png").toExternalForm()));

        Font labelFont = Font.font("Times New Roman", FontWeight.EXTRA_BOLD,44);
        Label label = new Label("Welcome to NewsApp");
        label.setTextFill(DARKRED);
        label.setAlignment(Pos.TOP_CENTER);
        label.setFont(labelFont);

        //Buttons
        Font buttonFont = Font.font("Times New Roman", FontWeight.NORMAL, 22);
        Button newsButton = new Button("News");
        newsButton.setStyle("-fx-background-color:#3A3B3C");
        newsButton.setTextFill(WHITE);
        newsButton.setFont(buttonFont);
        Button bitcoinButton = new Button("Bitcoin-News");
        bitcoinButton.setStyle("-fx-background-color:#3A3B3C");
        bitcoinButton.setTextFill(WHITE);
        bitcoinButton.setFont(buttonFont);
        Button numberOfArticlesButton = new Button("Number of Articles");
        numberOfArticlesButton.setStyle("-fx-background-color:#3A3B3C");
        numberOfArticlesButton.setTextFill(WHITE);
        numberOfArticlesButton.setFont(buttonFont);
        Button quitButton = new Button("Quit");
        quitButton.setStyle("-fx-background-color:#3A3B3C");
        quitButton.setTextFill(WHITE);
        quitButton.setFont(buttonFont);

        VBox menuBox = new VBox();
        menuBox.getChildren().addAll(label,newsButton,bitcoinButton,numberOfArticlesButton,quitButton);
        menuBox.setSpacing(30);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setFillWidth(true);

        //Logos
        Image menuLogo = new Image("/NewsAppLogo.png");
        ImageView imgView = new ImageView();
        ImageView imgView1 = new ImageView();
        ImageView imgView2 = new ImageView();
        ImageView imgView3 = new ImageView();
        imgView.setImage(menuLogo);
        imgView1.setImage(menuLogo);
        imgView2.setImage(menuLogo);
        imgView3.setImage(menuLogo);
        imgView.setFitWidth(70);
        imgView1.setFitWidth(70);
        imgView2.setFitWidth(70);
        imgView3.setFitWidth(70);
        imgView.setPreserveRatio(true);
        imgView1.setPreserveRatio(true);
        imgView2.setPreserveRatio(true);
        imgView3.setPreserveRatio(true);

        //Background-Style
        StackPane layout = new StackPane();
        StackPane.setAlignment(imgView,Pos.TOP_RIGHT);
        StackPane.setAlignment(imgView1,Pos.TOP_LEFT);
        StackPane.setAlignment(imgView2,Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(imgView3,Pos.BOTTOM_LEFT);
        Scene menuScene = new Scene(layout, APP_WIDTH, APP_HEIGHT);
        layout.setBackground(new Background(new BackgroundFill(LIGHTGRAY, null, null)));
        layout.getChildren().addAll(imgView, imgView1, imgView2, imgView3, menuBox);

        primaryStage.setScene(menuScene);
        primaryStage.setResizable(false);

        //Show Application
        primaryStage.show();
    }
}
        //die App Klasse enthält die main() Funktion und
        // erstellt eine Instanz von Menu.
        // Die Funktion Menu.start() wird aufgerufen.
