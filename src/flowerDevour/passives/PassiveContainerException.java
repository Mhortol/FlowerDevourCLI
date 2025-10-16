package flowerDevour.passives;

public class PassiveContainerException extends RuntimeException
{
   public PassiveContainerException(String message)
   {
      super("PassiveContainerException: " + message);
   }
}
