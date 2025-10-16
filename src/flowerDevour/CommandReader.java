package flowerDevour;

public class CommandReader
{
   public void interpret(String command)
   {
      switch (command)
      {
         case "new game":
            System.out.println("Temporary test text: new game");
            break;
         case "continue game":
            System.out.println("Temporary test text: continue game");
            break;
         case "choose room":
            System.out.println("Temporary test text: choose room");
            break;
         case "inventory":
            System.out.println("Temporary test text: inventory");
            break;
         case "equip":
            System.out.println("Temporary test text: equip");
            break;
         case "unequip":
            System.out.println("Temporary test text: unequip");
            break;
         case "map":
            System.out.println("Temporary test text: map");
            break;
         case "attack":
            System.out.println("Temporary test text: attack");
            break;
         default:
            System.out.println("Unrecognized command.");
      }
   }
}
