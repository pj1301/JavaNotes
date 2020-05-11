package exceptions;

public class Exceptions {

   public void handle(Exception e) {
      System.out.println("Exception has occurred -> " + e);
   }

   public void handle(Exception e, String location) {
      System.out.println("Exception has occurred -> " + e);
      System.out.println("The exception occurred in " + location);
   }
}