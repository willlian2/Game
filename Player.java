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
   Fighter fighter = new Fighter();
   Wizard wizard = new Wizard();
    public Player(Fighter fighter,Wizard wizard)
   {this.fighter=fighter;
    this.wizard=wizard;
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
     chancenum=chance.nextInt(2);
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
    {wizard.combatloop();
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
 else if(chance==1)
 {return("singlegoblin");
    }
    return("fail");
}
public void checkchancetable(String action,Combat combat)
    {if(action.contains("move"))
        {
        }
     else if(action.contains("singlegoblin"))
     {combat.singlegoblin();
        }
    }
}
