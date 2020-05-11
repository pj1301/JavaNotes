# JavaNotes

This is a simple notes app developed using JavaFX to practice the manipulation of elements and to test out writing data to a file through serialisation.

&nbsp;
## Functionality
To create a new note, simply enter the input into the input panel at the bottom of the app window. Then click the add button with the green tick. 

To edit a note, click on the note to be edited, then type in a new text entry in the field, then click the button with the blue pencil. This will update that field. 

To delete a field, click on the field to be deleted and then click on the button with the red trash can. 

![Screenshot of the application](./docs/assets/appScreen1.png)

&nbsp;
## Code Features

### Changing Dock Icon
This used to be handled by `com.apple.eawt.Application` but this has since been depreciated. Now it should be
 achieved using the following code snippet, which should be executed as part of the `main()` method on the base class:

```java
...
import java.awt.*;
import java.net.URL;
...

   private void start(Stage stage) throws Exception {
      ...
      try {
         setDockImage();
      } catch(Exception e) {
         // handle exception
      };
   }

    private void setDockImage() throws Exception {
       Toolkit dfTools = Toolkit.getDefaultToolkit();
       URL path = Main.class.getClassLoader().getResource("assets/javaNotes_logo.png");
       java.awt.Image image = dfTools.getImage(path);
       java.awt.Taskbar.getTaskbar().setIconImage(image);
    }
...
```



### Object Serialization

In this project, the notes are saved to a file inside the app via **serialization**.  The code to save and retrieve data is actually relatively simple.  

```java
package fileServer;
// include import of the Object class
import java.io.*;
import java.util.ArrayList;

public class FileServer {
  
  public void saveData(Object<T> content) throws Exception {
    ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("tmp/saveData.ser"));
    outStream.writeObject(content);
  }
  
  public Object<T> loadData() throws Exception {
    ObjectInputStream inStream = new ObjectInputStream(new FileOutputStream("tmp/saveData.ser"));
    return (Object<T>) inStream.readObject();
  }
  
}
```

_Note that the exceptions are necessary and IntelliJ will highlight an error if you haven't included them._



### ListView With Objects

I initially struggled to find a replacement for Angular's `*ngFor`, but then stumbled upon the ListView and `setCellFactory` . The process requires overriding a native method inside the ListCell object:

```java
ListView<T> listView = new ListView();
// you can set the list of objects to the ListView here
// e.g. listView.setAll(CONTENTS) OR listView.addAll(CONTENTS);
listView.setCellFactory(cell -> new ListCell<T>() {
  @Override
  public void updateItem(T item, boolean empty) {
    super.updateItem(item, empty);
    setText(empty ? null : item.getContent());
  }
})
```



&nbsp;
-------
**Author**

pj1301