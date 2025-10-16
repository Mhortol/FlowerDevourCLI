package flowerDevour.tools;

public class ToolContainerException extends RuntimeException
{
   public ToolContainerException(String message)
   {
      super("ToolContainerException: " + message);
   }
}
