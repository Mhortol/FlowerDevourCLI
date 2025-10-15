package flowerDevour.enemies;

import flowerDevour.Entity;
import flowerDevour.EntityException;
import flowerDevour.Player;
import flowerDevour.actions.BasicAction;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Enemy extends Entity implements Serializable
{
    private BasicAction move;

    public Enemy()
    {

    }

    public Enemy(int health, int maxHealth, String name, BasicAction move)
    {
        super(health, maxHealth, name);
        setMove(move);
        move.setUser(this);
    }

    //for copying objects
    public Enemy(Enemy enemy)
    {
        super(enemy);
        setMove(enemy.getMove());
    }

    public BasicAction getMove()
    {
        return move;
    }

    public void setMove(BasicAction move) throws EntityException
    {
        if (move == null)
        {
            throw new EntityException("Null move.");
        }

        this.move = move;
    }

    public void doMove()
    {
        move.setTarget(super.getTarget());
        move.execute();
    }

    public void doMove(Player player)
    {
        move.setUser(player);
        move.setTarget(super.getTarget());
        move.execute();
    }

    @Override
    public String toString()
    {
        return "Enemy{" +
            "move=" + move +
            super.toString() +
            '}';
    }
}
