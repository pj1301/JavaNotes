package sample;

import exceptions.Exceptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

public class Main extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      primaryStage.setTitle("NotesApp");
      primaryStage.getIcons().add(new Image("assets/javaNotes_logo.png"));
      Scene rootScene = new Scene(root, 600, 400);
      rootScene.getStylesheets().add("styles.css");
      primaryStage.setScene(rootScene);
      primaryStage.show();
      try {
         setDockImage();
      }
      catch(Exception e) { new Exceptions().handle(e); }
   }

   public static void main(String[] args) {
      launch(args);
   }

   private void setDockImage() throws Exception {
      Toolkit dfTools = Toolkit.getDefaultToolkit();
      URL path = Main.class.getClassLoader().getResource("assets/javaNotes_logo.png");
      java.awt.Image image = dfTools.getImage(path);
      java.awt.Taskbar.getTaskbar().setIconImage(image);
   }
}