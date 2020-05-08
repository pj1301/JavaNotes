package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import fileServer.FileServer;
import exceptions.Exceptions;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


public class Controller implements Serializable {
   final FileServer fileServer = new FileServer();
   final Exceptions exceptions = new Exceptions();

   @FXML
   public TextField textInput;
   public Button printBtn;
   public ListView<String> listViewContainer;

   public void handleSave() {
      if (textInput.getText().equals("")) {
         return;
      }
      ObservableList<String> list = listViewContainer.getItems();
      list.add(textInput.getText());
      resetInput();
   }

   public void handleDelete() {
      int itemIndex = getSelectedItemIndex();
      if (itemIndex == -1) { return; }
      listViewContainer.getItems().remove(itemIndex);
   }

   public void handleEdit() {
      int itemIndex = getSelectedItemIndex();
      if (itemIndex == -1) { return; }
      String content = textInput.getText();
      listViewContainer.getItems().remove(itemIndex);
      listViewContainer.getItems().add(itemIndex, content);
      resetInput();
   }

   private int getSelectedItemIndex() {
      return listViewContainer.getSelectionModel().getSelectedIndex();
   }

   private void resetInput() { textInput.setText(""); }
}