package flowerDevour;



import flowerDevour.passives.PassiveContainer;
import flowerDevour.passives.PassiveItem;
import flowerDevour.tools.Tool;
import flowerDevour.tools.ToolContainer;
import flowerDevour.tools.ToolContainerException;

import java.util.HashMap;
import java.util.Map;

//TODO: based on the equipped weapon the default animation should change

/**
 * The class that represents the player.
 * <p>
 * Holds containers for equipped tools, inventory and passives and a damage modifier.
 */
public class Player extends Entity
{
    public static final int EQUIP_SLOTS = 4;
    public static final int INVENTORY_SLOTS = 20;
    public static final int MAX_PASSIVES = 100;

    private ToolContainer equippedTools = new ToolContainer(EQUIP_SLOTS);
    private ToolContainer inventory = new ToolContainer(INVENTORY_SLOTS);
    private PassiveContainer passives = new PassiveContainer(MAX_PASSIVES);
    private int selectedTool = 0;

    private double damageModifier = 1;

    public Player(int health, int maxHealth, String name, Tool starterTool)
    {
        super(health, maxHealth, name);
        equippedTools.moveInside(new Tool(starterTool));
    }

    public Player(int health, int maxHealth, String name, ToolContainer starterTools)
    {
        super(health, maxHealth, name);
        setEquippedTools(starterTools);
    }

    public void setDamageModifier(double damageModifier)
    {
        this.damageModifier = damageModifier;
    }

    public void setEquippedTools(ToolContainer equippedTools)
    {
        this.equippedTools = new ToolContainer(equippedTools);
    }

    public void setSelectedTool(int selectedTool) throws PlayerException
    {
        if (selectedTool > EQUIP_SLOTS - 1 || selectedTool < 0)
        {
            throw new ToolContainerException("Trying to select tool out of range!");
        }

        this.selectedTool = selectedTool;
    }

    public void setPlayerTarget(Entity target)
    {
        super.setTarget(target);
    }

    public double getDamageModifier()
    {
        return damageModifier;
    }


    /**
     * Equips tool to first empty equip slot.
     *
     * @param inventoryIndex Index of tool to equip.
     * @return Place in equip index.
     */
    public int equipTool(int inventoryIndex)
    {
        return inventory.moveOneInto(inventoryIndex, equippedTools);
    }

    /**
     * Equips tool to selected slot.
     *
     * @param equipSlotIndex Selected slot.
     * @param inventoryIndex Index of tool to equip.
     */
    public void equipTool(int equipSlotIndex, int inventoryIndex)
    {
        inventory.moveOneInto(inventoryIndex, equipSlotIndex, equippedTools);
    }

    /**
     * Unequips tool to first empty inventory slot.
     *
     * @param equipSlotIndex Index of tool to unequip.
     * @return Place in inventory index.
     */
    public int unequipTool(int equipSlotIndex)
    {
        return equippedTools.moveOneInto(equipSlotIndex, inventory);
    }

    /**
     * Unequips tool to selected inventory slot.
     *
     * @param inventoryIndex Selected slot.
     * @param equipSlotIndex Index of tool to unequip.
     */
    public void unequipTool(int inventoryIndex, int equipSlotIndex)
    {
        equippedTools.moveOneInto(equipSlotIndex, inventoryIndex, inventory);
    }

    /**
     * Rewards a Player with a new Tool.
     * Tool is put into Player inventory.
     *
     * @param reward The tool the Player is being rewarded with.
     * @return Returns index of where the reward was placed in inventory.
     */
    public int rewardTool(Tool reward) //TODO: add try-catch block for when the player has a full inventory
    {
        return inventory.moveInside(reward);
    }

    /**
     * Rewards a Player with a new PassiveItem.
     * PassiveItem is put int Player passives.
     *
     * @param reward The PassiveItem the Player is being rewarded with.
     * @return Returns index of where the reward was placed in passives.
     */
    public int rewardPassive(PassiveItem reward)
    {
        return passives.moveInside(reward);
    }

    /**
     * @return Returns number of equipped Tools.
     */
    public int getEquippedCount()
    {
        return equippedTools.filledSlots();
    }

    /**
     * @return Returns number of unequipped Tools in inventory.
     */
    public int getUnequippedCount()
    {
        return inventory.filledSlots();
    }

    /**
     * @return Returns number of PassiveItems the Player has.
     */
    public int getPassivesCount()
    {
        return passives.filledSlots();
    }

    /**
     * Executes the BasicAction of the current selected Tool from the equippedSlots on selected target Entity.
     *
     * @throws PlayerException Throws if selected Tool is null.
     */
    public void doMove() throws PlayerException
    {
        if (equippedTools.getTool(selectedTool) == null)
        {
            throw new PlayerException("Trying to act on nothing!");
        }

        Tool actingTool = new Tool(equippedTools.getTool(selectedTool));

        int targetChange = actingTool.getMove().getTargetChange();

        targetChange *= (int) damageModifier;

        actingTool.getMove().setTargetChange(targetChange);

        actingTool.execute(this, super.getTarget());
    }
}
