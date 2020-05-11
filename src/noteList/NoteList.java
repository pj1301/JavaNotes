package noteList;
import note.Note;
import fileServer.FileServer;
import exceptions.Exceptions;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NoteList {
   private ArrayList<Note> list = new ArrayList<Note>();
   final FileServer server = new FileServer();
   final Exceptions exceptions = new Exceptions();

   public ArrayList<Note> getNotes() {
      return list;
   }

   public void setNotes(ArrayList<Note> notes) { this.list = notes; }

   public void createNote(String content) {
      String timeStamp = "Today";
      Note createdNote = new Note(content, timeStamp);
      list.add(createdNote);
      saveData(list);
   }

   public void updateNote(int index, String content) {
      list.get(index).setContent(content);
      saveData(list);
   }

   public void removeNote(int index) {
//      this.list = list.stream()
//         .filter(v -> v.getId().equals(noteId))
//         .collect(Collectors.toCollection(ArrayList::new));
      list.remove(index);
      saveData(list);
   }

   private void saveData(ArrayList<Note> noteList) {
      try {
         server.saveData(noteList);
      } catch(Exception e) {
         exceptions.handle(e);
      }
   }

}