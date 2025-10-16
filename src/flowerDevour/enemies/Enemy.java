package flowerDevour.enemies;

import flowerDevour.Entity;
import flowerDevour.EntityException;
import flowerDevour.Player;
import flowerDevour.actions.BasicAction;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * This is a basic Enemy that can do one {@link BasicAction}.
 * <p>
 * The turn of an Enemy should look like this:
 * <p>
 * 1. Set the Enemy's target.
 * <p></p>
 * 2. The Enemy does its move.
 * <p>
 * 3. The Enemy passes it's turn.
 */
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
   
   /**
    * Set's the {@link BasicAction}'s user to this {@link Enemy}
    * and target to {@link Enemy}'s target, then executes it.
    */
   public void doMove()
   {
      move.setUser(this);
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
