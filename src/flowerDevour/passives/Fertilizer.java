package flowerDevour.passives;


//TODO:Add updates to the item so that the modifier would dynamically change when a new item is obtained

import flowerDevour.Player;

/**
 * When obtained, increases the damage modifier of player
 * by 0.25 per passive item.
 */
public class Fertilizer extends PassiveItem
{
   public void onGet(Player owner)
   {
      int passives = owner.getPassivesCount();
      
      double modifier = 0.25 * passives;
      
      modifier += owner.getDamageModifier();
      
      owner.setDamageModifier(modifier);
   }
}
