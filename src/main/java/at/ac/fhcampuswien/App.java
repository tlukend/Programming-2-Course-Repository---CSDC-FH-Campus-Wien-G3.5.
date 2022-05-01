package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.Language;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;


import javax.swing.plaf.metal.MetalBorders;

import java.util.List;

import static javafx.scene.paint.Color.*;

public class App extends Application {
    //Variables
    protected final static int APP_HEIGHT = 750;
    protected final static int APP_WIDTH = 1000;
    protected static StackPane mainMenu;



    public static void main(String[] args) {
        launch(args);

        /* Menu menu = new Menu();
        menu.start(); wird nicht mehr gebraucht wegen GUI */

    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        AppController ctrl = new AppController();


        //main menu
        primaryStage.setTitle("N E W S A P P");
        primaryStage.getIcons().add(new Image(getClass().getResource("/NewsAppLogo.png").toExternalForm()));

        Font labelFont = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 35);
        Font articleText = Font.font("Times New Roman",FontWeight.NORMAL, 20);
        Label welcomeText = new Label("Welcome to NewsApp");

        Label topHeadlinesAustriaText = new Label("Top Headlines Austria");
        Label countText = new Label("Number of Articles: " + ctrl.getArticleCount()); //muss noch auf die variable Article.count abgestimmt werden
        Label bitcoinNews = new Label("Bitcoin News"); //bitcoin news muss noch programmiert werden
        welcomeText.setTextFill(DARKRED);
        welcomeText.setAlignment(Pos.TOP_CENTER);
        welcomeText.setFont(labelFont);

        //Buttons
        Font buttonFont = Font.font("Times New Roman", FontWeight.NORMAL, 22);
        Button topHeadlinesAustriaButton = new Button("Top Headlines Austria");
        topHeadlinesAustriaButton.setStyle("-fx-background-color:#3A3B3C");
        topHeadlinesAustriaButton.setTextFill(WHITE);
        topHeadlinesAustriaButton.setFont(buttonFont);
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
        menuBox.getChildren().addAll(welcomeText, topHeadlinesAustriaButton, bitcoinButton, numberOfArticlesButton, quitButton);
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
        Button menuButton = new Button("Menü");
        menuButton.setStyle("-fx-background-color:#3A3B3C");
        menuButton.setTextFill(WHITE);
        menuButton.setFont(buttonFont);
        StackPane.setAlignment(menuButton, Pos.BOTTOM_CENTER);

        VBox bitCoinBox = new VBox();
        bitCoinBox.getChildren().addAll(bitcoinNews);
        bitCoinBox.setAlignment(Pos.CENTER);
        bitCoinBox.setFillWidth(true);
        menuBox.setSpacing(30);

        Scene menuScene = new Scene(mainMenu, APP_WIDTH, APP_HEIGHT);
        mainMenu.setBackground(new Background(new BackgroundFill(LIGHTGRAY, null, null)));
        mainMenu.getChildren().addAll(imgView, imgView1, imgView2, imgView3, menuBox, menuButton);
        menuButton.setOnAction(actionEvent -> {
            mainMenu.getChildren().removeAll(countText, bitCoinBox, topHeadlinesAustriaText);
            mainMenu.getChildren().add(menuBox);   //habe versucht, wenn ich auf einen Button rauf drücke und zurück ins Menü komme, alles wieder zu ist und nicht noch offen!
        });
        //when clicking the numberOfArticles button
        numberOfArticlesButton.setOnAction(event -> {
            mainMenu.getChildren().remove(menuBox);
            countText.setTextFill(BLACK);
            countText.setAlignment(Pos.TOP_CENTER);
            countText.setFont(articleText);
            countText.setText("Number of Articles: " + ctrl.getArticleCount());
            mainMenu.getChildren().add(countText);

        });

        //when clicking the getAllNewsBitcoin button

        //Slavica bitte anschauen, ob diese Idee Sinn ergibt - Menütaste funktioniert trotzdem nicht
        bitcoinButton.setOnAction(event -> {
            mainMenu.getChildren().remove(menuBox);
            bitcoinNews.setTextFill(BLACK);
            bitcoinNews.setAlignment(Pos.TOP_CENTER);
            bitcoinNews.setLineSpacing(10);
            //bitcoinNews.setPadding(new Insets(90));
            bitcoinNews.setFont(articleText);
            bitcoinNews.setText(getAllNewsBitcoin(ctrl));
            bitcoinNews.setMouseTransparent(true);
            bitCoinBox.setMouseTransparent(true);
            mainMenu.getChildren().add(bitCoinBox);
        });



            //when clicking the topHeadlinesAustria button
        topHeadlinesAustriaButton.setOnAction(event -> {
            mainMenu.getChildren().remove(menuBox);
            topHeadlinesAustriaText.setTextFill(BLACK);
            topHeadlinesAustriaText.setAlignment(Pos.TOP_CENTER);
            topHeadlinesAustriaText.setLineSpacing(10);
            topHeadlinesAustriaText.setPadding(new Insets(90));
            topHeadlinesAustriaText.setFont(articleText);
            topHeadlinesAustriaText.setText(getTopHeadlinesAustria(ctrl));
            topHeadlinesAustriaText.setMouseTransparent(true);
            mainMenu.getChildren().add(topHeadlinesAustriaText);
        });

        primaryStage.setScene(menuScene);
        primaryStage.setResizable(true);

        //Show Application
        primaryStage.show();
    }

    private String getAllNewsBitcoin(AppController ctrl) {
        List<Article> articles = ctrl.getAllNewsBitcoin();
        if (articles.size() == 0){
            return "There are no news about Bitcoin.";
        }
            String output = "";
        for (int i = 0; i < articles.size(); i++) {
            output += articles.get(i).getAuthorAndTitle()+System.lineSeparator() + System.lineSeparator();
        }
        return output;
    }

    private String getTopHeadlinesAustria(AppController ctrl) {
        List<Article> articles = ctrl.getTopHeadlinesAustria();
        if (articles.size() == 0){
            return "There are no news about Austria.";
        }
            String output = "";
        for (int i = 0; i < articles.size(); i++) {
            output += articles.get(i).getAuthorAndTitle()+System.lineSeparator() + System.lineSeparator();
        }

        return output;
    }


}
