package flowerDevour.actions;

public class ActionException extends RuntimeException
{
   public ActionException(String message)
   {
      super("ActionException: " + message);
   }
}
