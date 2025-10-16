package flowerDevour;

import flowerDevour.actions.BasicAction;
import flowerDevour.tools.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandReader
{
   private Player player;
   private Map map;
   
   public void interpret()
   {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      
      try
      {
         while (true)
         {
            String command = reader.readLine();
            
            switch (command)
            {
               case "new game":
                  System.out.println("What is your name?");
                  String name = reader.readLine();
                  newGame(name);
                  System.out.println(name);
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
               case "exit", "quit":
                  System.exit(0);
                  break;
               default:
                  System.out.println("Unrecognized command.");
            }
         }
      } catch (IOException e)
      {
         throw new RuntimeException(e);
      }
   }
   
   private void newGame(String name)
   {
      player =  new Player(20, 20, name, new Tool("Old Rake", new BasicAction(0, 5, "Scrape")));
      map = new Map();
   }
   
   
}
