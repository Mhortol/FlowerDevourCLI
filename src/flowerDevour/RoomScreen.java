package flowerDevour;

public class RoomScreen
{
   private Room room;
   
   public RoomScreen(Room room)
   {
      setRoom(room);
   }
   
   public Room getRoom()
   {
      return room;
   }
   
   public void setRoom(Room room)
   {
      this.room = room;
   }
}
