package flowerDevour.passives;

import flowerDevour.Item;
import flowerDevour.Player;

import java.io.Serializable;


/**
 * Parent class for all passive items the player can find.
 */
public class PassiveItem extends Item implements Serializable
{
    public PassiveItem()
    {

    }

    public PassiveItem(PassiveItem passive)
    {
        super(passive);
    }

    public PassiveItem(String name)
    {
        super(name);
    }

    /**
     * Abstract method to do something when a passive is obtained.
     *
     * @param owner the Player that got the item.
     */
    public void onGet(Player owner)
    {

    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
