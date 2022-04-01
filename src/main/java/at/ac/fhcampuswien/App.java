package at.ac.fhcampuswien;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.*;

public class App extends Application {
    //Variables
    protected final static int APP_HEIGHT = 750;
    protected final static int APP_WIDTH = 1000;
    protected static StackPane mainMenu;


    public static void main(String[] args) {
        launch(args);
        Menu menu = new Menu();
        //hier soll menu.start rein
    }

    @Override
    public void start(Stage primaryStage) {

        //Objects
        //AppController<Object> www = new AppController<>();
        AppController ctrl = new AppController();

        //main menu
        primaryStage.setTitle("N E W S A P P");
        primaryStage.getIcons().add(new Image(getClass().getResource("/NewsAppLogo.png").toExternalForm()));

        Font labelFont = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 44);
        Label welcomeText = new Label("Welcome to NewsApp");
        Label countText = new Label("Number of Articles: " + ctrl.getArticleCount()); //muss noch auf die variable Article.count abgestimmt werden
        Label bitcoinNews = new Label("Bitcoin News"); //bitcoin news muss noch programmiert werden
        welcomeText.setTextFill(DARKRED);
        welcomeText.setAlignment(Pos.TOP_CENTER);
        welcomeText.setFont(labelFont);

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
        quitButton.setOnAction(actionEvent -> Platform.exit());

        //design main menu
        VBox menuBox = new VBox();
        menuBox.getChildren().addAll(welcomeText, newsButton, bitcoinButton, numberOfArticlesButton, quitButton);
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
        mainMenu = new StackPane();
        StackPane.setAlignment(imgView, Pos.TOP_RIGHT);
        StackPane.setAlignment(imgView1, Pos.TOP_LEFT);
        StackPane.setAlignment(imgView2, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(imgView3, Pos.BOTTOM_LEFT);
        Button menue = new Button("Menü");  //Menü Button wurde hinzugefügt
        menue.setStyle("-fx-background-color:#3A3B3C");
        menue.setTextFill(WHITE);
        menue.setFont(buttonFont);
        StackPane.setAlignment(menue, Pos.BOTTOM_CENTER);

        Scene menuScene = new Scene(mainMenu, APP_WIDTH, APP_HEIGHT);
        mainMenu.setBackground(new Background(new BackgroundFill(LIGHTGRAY, null, null)));
        mainMenu.getChildren().addAll(imgView, imgView1, imgView2, imgView3, menuBox, menue);
        menue.setOnAction(actionEvent -> {
            mainMenu.getChildren().removeAll(countText, bitcoinNews);
            mainMenu.getChildren().add(menuBox);   //habe versucht, wenn ich auf einen Button rauf drücke und zurück ins Menü komme, alles wieder zu ist und nicht noch offen!
        });
        //when clicking the numberOfArticles button
        numberOfArticlesButton.setOnAction(event -> {
            mainMenu.getChildren().remove(menuBox);
            countText.setTextFill(DARKRED);
            countText.setAlignment(Pos.TOP_CENTER);
            countText.setFont(labelFont);
            countText.setText("Number of Articles: " + ctrl.getArticleCount());
            mainMenu.getChildren().add(countText);

        });
        //when clicking the getAllNewsBitcoin button
        bitcoinButton.setOnAction(event -> {
            mainMenu.getChildren().remove(menuBox);
            bitcoinNews.setTextFill(DARKRED);
            bitcoinNews.setAlignment(Pos.TOP_CENTER);
            bitcoinNews.setFont(labelFont);
            mainMenu.getChildren().add(bitcoinNews);
        });

        primaryStage.setScene(menuScene);
        primaryStage.setResizable(true);

        //Show Application
        primaryStage.show();
    }
}
