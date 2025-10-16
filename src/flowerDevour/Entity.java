package flowerDevour;

import flowerDevour.actions.ActionException;

import java.io.Serializable;


/**
 * Base class for {@link flowerDevour.enemies.Enemy} and {@link Player} objects.
 * <p>
 * Holds basic statistics like health, name, etc.
 * <p>
 * Each Entity has a target Entity. This field is used
 * in combination with the doMove() method.
 * <p>
 * At it's most basic, doMove() should set the
 * targets for a {@link flowerDevour.actions.BasicAction} and then execute it.
 * <p>
 * The turn of an Entity should look like this:
 * <p></p>
 * 1. Set the targets of the BasicAction.
 * <p>
 * 2. Execute the BasicAction.
 * </p>
 * 3. Pass the turn.
 */
public class Entity implements Serializable
{
   private int health;
   private int maxHealth;
   private String name;
   private Entity target;
   
   public Entity()
   {
   
   }
   
   public Entity(int health, int maxHealth, String name)
   {
      setMaxHealth(maxHealth);
      setHealth(health);
      setName(name);
   }
   
   //for copying objects
   public Entity(Entity entity) throws EntityException
   {
      if (entity == null)
      {
         throw new EntityException("Trying to copy nothing.");
      }
      
      setMaxHealth(entity.getMaxHealth());
      setHealth(entity.getHealth());
      setName(entity.getName());
      //etc. TODO: copy remaining fields.
   }
   
   public int getHealth()
   {
      return health;
   }
   
   public int getMaxHealth()
   {
      return maxHealth;
   }
   
   public String getName()
   {
      return name;
   }
   
   public Entity getTarget()
   {
      return target;
   }
   
   /**
    * @param health New health value, it cannot exceed maxHealth.
    */
   public void setHealth(int health)
   {
      if (health >= maxHealth)
      {
         this.health = this.maxHealth;
         return;
      }
      if (health <= 0)
      {
         this.health = 0;
         return;
      }
      
      this.health = health;
   }
   
   public void setMaxHealth(int maxHealth)
   {
      this.maxHealth = maxHealth;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
    * Mandatory to set up before using doMove()
    *
    * @param target The {@link Entity} that will be targeted.
    * @throws ActionException
    */
   public void setTarget(Entity target) throws ActionException
   {
      if (target == null)
      {
         throw new ActionException("Attempting to target nothing!");
      }
      
      this.target = target;
   }
   
   /**
    * Abstract method.
    * Executes selected BasicAction on target.
    */
   public void doMove()
   {
   
   }
   
   public boolean isDead()
   {
      if (getHealth() == 0)
      {
         return true;
      }
      return false;
   }
   
   @Override
   public String toString()
   {
      return "Entity{" +
              "health=" + health +
              ", maxHealth=" + maxHealth +
              ", name='" + name + '\'' +
              '}';
   }
}