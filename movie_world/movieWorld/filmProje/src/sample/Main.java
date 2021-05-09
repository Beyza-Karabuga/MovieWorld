package sample;

import com.jfoenix.controls.JFXListView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Movie World");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1000);
        primaryStage.setResizable(false);
        root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
