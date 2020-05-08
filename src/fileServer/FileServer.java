package fileServer;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.List;

public class FileServer {

   public void saveData(List<String> content) throws Exception {
      FileOutputStream fileOut = new FileOutputStream("/tmp/appData.ser");
      ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
      outStream.writeObject(content);
      outStream.close();
      fileOut.close();
   }

   public void retrieveData() {}

   public void editData() {}

   public void removeData() {}
}