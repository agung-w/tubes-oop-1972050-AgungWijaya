package com.ysa.admin;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application {
    private double xOffset = 0 ;
    private double yOffset =0;
    @Override
    public void start(Stage stage) throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("bundle",new Locale("ENG"));
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("hello-view.fxml"),rb);
        fxmlLoader.setOnMousePressed(mouseEvent -> {
            xOffset = mouseEvent.getSceneX();
            yOffset = mouseEvent.getSceneY();
        });
        fxmlLoader.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - xOffset);
            stage.setY(mouseEvent.getScreenY() - yOffset);
        });


        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(fxmlLoader));
        stage.setTitle("YSA Learning System");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}