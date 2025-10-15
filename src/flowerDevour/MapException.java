package flowerDevour;

public class MapException extends RuntimeException
{
    public MapException(String message)
    {
        super("MapException: " + message);
    }
}
