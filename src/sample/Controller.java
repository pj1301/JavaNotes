package sample;

import noteList.NoteList;
import note.Note;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import fileServer.FileServer;
import exceptions.Exceptions;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Controller implements Serializable {
   final FileServer fileServer = new FileServer();
   final Exceptions exceptions = new Exceptions();
   final NoteList noteList = new NoteList();

   @FXML
   public TextField textInput;
   public Button printBtn;
   public ListView<Note> listViewContainer;

   public void initialize() {
      try {
         ArrayList<Note> savedNotes = fileServer.retrieveData();
         if (savedNotes.size() > 0) {
            noteList.setNotes(savedNotes);
            updateNoteList(savedNotes);
         }
      } catch(Exception e) {
         exceptions.handle(e, "initialisation");
      }
   }

   public void handleSave() {
      if (textInput.getText().equals("")) {
         return;
      }
      noteList.createNote(textInput.getText());
      updateNoteList(noteList.getNotes());
      resetInput();
   }

   public void handleDelete() {
      int itemIndex = getSelectedItemIndex();
      if (itemIndex == -1) { return; }
      noteList.removeNote(itemIndex);
      updateNoteList(noteList.getNotes());
   }

   public void handleEdit() {
      int itemIndex = getSelectedItemIndex();
      if (itemIndex == -1) { return; }
      String content = textInput.getText();
      noteList.updateNote(itemIndex, content);
      updateNoteList(noteList.getNotes());
      resetInput();
   }

   private int getSelectedItemIndex() {
      return listViewContainer.getSelectionModel().getSelectedIndex();
   }

   private void resetInput() { textInput.setText(""); }

   private void updateNoteList(ArrayList<Note> notes) {
      ObservableList<Note> list = listViewContainer.getItems();
      list.setAll(notes);
      listViewContainer.setCellFactory(cell -> new ListCell<Note>() {
         @Override
         public void updateItem(Note note, boolean empty) {
            super.updateItem(note, empty);
            setText(empty ? null : note.getContent());
         }
      });
   }
}