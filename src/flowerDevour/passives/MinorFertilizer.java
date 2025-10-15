package flowerDevour.passives;


import flowerDevour.Player;

/**
 * Adds 1 to the player's damage modifier.
 */
public class MinorFertilizer extends PassiveItem
{
    @Override
    public void onGet(Player owner)
    {
        double modifier = owner.getDamageModifier();

        modifier += 1;

        owner.setDamageModifier(modifier);
    }
}
