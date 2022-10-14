package com.example.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConnectFour extends Application {
    private ConnectFourController controller;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(ConnectFour.class.getResource("connect-view.fxml"));
        GridPane rootNode = loader.load();
        controller = loader.getController();
        controller.createPlayground();
        Scene scene = new Scene(rootNode);
        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        Pane menuPane = (Pane) rootNode.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        stage.setTitle("Connect Four");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public MenuBar createMenu(){
        //Declaring MenuBar
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");
        MenuBar menuBar =  new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        //Declaring Menu Items
        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());


        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame());
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit game");
        exitGame.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newGame,resetGame,separator,exitGame);

        MenuItem aboutGame = new MenuItem("About Game");
        aboutGame.setOnAction(event -> aboutGame());
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());
        helpMenu.getItems().addAll(aboutGame,aboutMe);


        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Me");
        alert.setHeaderText("Rohan Kanojia");
        alert.setContentText("I am Creating this game");
        alert.show();
    }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Game");
        alert.setHeaderText("Connect Four Game");
        alert.setContentText("Connect Four is a two-player connection board game, in which the players choose a color and then take turns dropping colored tokens into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the lowest available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own tokens.");
        alert.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}