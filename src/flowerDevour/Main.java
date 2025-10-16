package flowerDevour;

/*
Rough plan for this project:
1. Implement JSON reading to return functionality to GameMaster class.
2. Terminal main menu:
   a. display the options that the user can choose (New Game and Continue Game);
   b. explain how to choose each option.
3. Map display in terminal:
   a. display rooms, room type;
   b. display the paths between rooms;
   c. explain how the map works and how to pick a room on the map to enter.
4. Combat room display in terminal:
   a. rudimentary ASCII art of player and enemy;
   b. display the player's actions;
   c. explain what this screen is and how to choose an action to do.
5. Inventory display in terminal.
   a. display all inventory slots;
   b. display tools in inventory;
   c. display equipped tools;
   c. explain how to equip or unequip a tool.
6. Loot room display in terminal.
   a. display passive item within loot room;
   c. option to accept or reject item.
7. Option to save progress.
   a. naming a save file and choosing a save file.
8. Display passive items in rooms, map and inventory.
   a. Simple ASCII art icons, no larger than 3x3, probably 2x2.
9. Option to query functionality of a passive item.
10. Option to query functionality of a tool.
11. Add colors and refine ASCII art.
   a. Improve the ASCII art of rooms, paths, player and enemies;
   b. Add color to game elements, menus, titles, icons etc.
12. Expand the game with more floors, items, tools, enemies and potentially starting characters.
*/

public class Main
{
   public static void main(String[] args)
   {
      System.out.println("Hello, World!");
      
      System.out.println(GameMaster.getEnemies().toString());
      
      System.out.println(GameMaster.getTools().toString());
      
      System.out.println(GameMaster.getPassives().toString());
   }
}