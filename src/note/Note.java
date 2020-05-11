package note;

import java.io.Serializable;
import java.util.UUID;

public class Note implements Serializable {
   private String content;
   private final String id;
   private final String timeStamp;

   public Note(String content, String timeStamp) {
      this.id = UUID.randomUUID().toString();
      this.content = content;
      this.timeStamp = timeStamp;
   }

   public String getId() { return id; }

   public String getContent() { return content; }

   public void setContent(String content) { this.content = content; }

   public String getTimeStamp() { return timeStamp; }

}