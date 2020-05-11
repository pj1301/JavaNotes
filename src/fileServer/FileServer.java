package fileServer;

import note.Note;

import java.io.*;
import java.util.ArrayList;

public class FileServer {

   public void saveData(ArrayList<Note> noteList) throws Exception {
      ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream("tmp/appData.ser"));
      objectStream.writeObject(noteList);
   }

   public ArrayList<Note> retrieveData() throws Exception {
      ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("tmp/appData.ser"));
      return (ArrayList<Note>) objectStream.readObject();
   }

}