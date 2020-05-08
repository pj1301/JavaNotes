package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      primaryStage.setTitle("NotesApp");
      Scene rootScene = new Scene(root, 600, 400);
      rootScene.getStylesheets().add("styles.css");
      primaryStage.setScene(rootScene);
      primaryStage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}