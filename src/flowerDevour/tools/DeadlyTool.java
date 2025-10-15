package flowerDevour.tools;


import flowerDevour.Entity;
import flowerDevour.Player;
import flowerDevour.actions.BasicAction;

public class DeadlyTool extends Tool
{
    DeadlyTool()
    {
        super();
    }

    @Override
    public void execute(Entity user, Entity target)
    {
        BasicAction move = super.getMove();

        int targetChange = move.getTargetChange();


        if (user.getClass() == Player.class)
        {
            double modifier = 1;
            modifier = ((Player) user).getDamageModifier();
            int newChange = (int) (targetChange * modifier);
            move.setTargetChange(newChange);
        }

        super.execute(user, target);

        move.setTargetChange(targetChange);
    }
}
