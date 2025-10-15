package flowerDevour;

public class PlayerException extends RuntimeException
{
    public PlayerException(String message)
    {
        super("PlayerException: " + message);
    }
}
