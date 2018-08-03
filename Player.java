import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
   
    public Player()
   {
    }
   public String getplayeraction(Maptile maptile)
   {if(maptile.gettilenumber()==7)
       {   Random random = new Random();
           
           Maptile tile = new Maptile(random.nextInt(7));
           
           return(getplayeraction(tile));
        }
    else
    {
     Scanner scanner = new Scanner(System.in);
     String action;
     Random chance = new Random();
     int chancenum;
     chancenum=chance.nextInt(1);
     boolean check=true;
     System.out.println(maptile.readtile());
     System.out.println("What would you like to do?");
     action=scanner.nextLine();
     if(action.contains("exit"))
     {  System.out.println("Goodbye!");
         System.exit(0);
        }
     else if(action.contains("move"))
     {Scanner directionget = new Scanner(System.in);
         while(check=true)
         {String direction;
          System.out.println("Which direction do you want to go?");
         direction=directionget.nextLine();
         if(direction.contains("left"))
         {
             if(maptile.gettilenumber()==1||maptile.gettilenumber()==5||maptile.gettilenumber()==6||maptile.gettilenumber()==0)
             {System.out.println("You go left");
            return(chancetable(chancenum));
           }
           else
           {System.out.println("There is no door to the left");
            }
            }
         else if(direction.contains("right"))
          {if(maptile.gettilenumber()==1||maptile.gettilenumber()==2||maptile.gettilenumber()==4||maptile.gettilenumber()==6)
             {System.out.println("You go right");
            return(chancetable(chancenum));
           }
           else
           {System.out.println("There is no door to the right");
            }
            }
         else if(direction.contains("straight"))
          {if(maptile.gettilenumber()==1||maptile.gettilenumber()==2||maptile.gettilenumber()==3||maptile.gettilenumber()==0)
             {System.out.println("You go straight");
            return(chancetable(chancenum));
           }
           else
           {System.out.println("There is no door ahead");
            }
            }
         else if(direction.contains("cancel"))
         {return(getplayeraction(maptile));
            }
         else
          {System.out.println("I only know left, right,and straight for direction");
            }
        }
    }
    else if (action.contains("test"))
    {Goblin goblin = new Goblin();
     Fighter fighter = new Fighter();
        while(fighter.gethealth()>0)
        {
     Attackinformation attack = goblin.combatloop();
        System.out.println(attack.gettohit());
        System.out.println(attack.getdmg());
        System.out.println(attack.target());
        System.out.println(attack.iscrit());
        fighter.takeattack(attack);
        System.out.println(fighter.gethealth());
    }
    }
    else
    {System.out.println("Sorry I only know stuff");
     return(getplayeraction(maptile));
    }
    return("empty");
    }
}
public String chancetable(int chance)
{if(chance==0)
    {return("move");
    }
    return("fail");
}
}
