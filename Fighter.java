import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Fighter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fighter extends Charater
{
    int health=12;
    int attack=4;
    int AC=15;
    public Fighter()
    {
    }

    public void takeattack(Attackinformation attackinformation)
    {if(attackinformation.gettohit()>AC&&attackinformation.iscrit()==true)
        {health=health-attackinformation.getdmg()*2;
            System.out.println("The attack hits fighter! They take "+attackinformation.getdmg()*2);
        }
        else if(attackinformation.gettohit()>AC&&attackinformation.iscrit()==false)
        {health=health-attackinformation.getdmg();
            System.out.println("The attack hits fighter! They take "+attackinformation.getdmg());

        }
        else
        {System.out.println("The attack misses fighter!");
        }
    }
    public void takehealing(Attackinformation attackinformation)
    {if(health+attackinformation.getdmg()>12)
        {health=12;
         System.out.println("Figher is healed and now has 12 health");
        }
     else
     {health=health+attackinformation.getdmg();
         System.out.println("Figher is healed and now has"+health+"health");
        }
    }
    public int basicattack()
    {Random random = new Random();
        int hit=random.nextInt(20)+attack+1;
        return hit;
    }

    public int damage()
    {Random random = new Random();
        int dmg=random.nextInt(6)+2+1;
        return dmg;
    }

    public int gethealth()
    {return health;
    }

    public int getAC()
    {return AC;
    }

    public Attackinformation combatloop()
    {System.out.println("What will fighter do?");
        Scanner scanner = new Scanner(System.in);
        String action=scanner.nextLine();
        if(action.contains("attack"))
        {System.out.println("What will fighter attack?");
            Scanner targetchoice = new Scanner(System.in);
            String target = scanner.nextLine();
            int tohit = this.basicattack();
            int dmg = this.damage();

            boolean iscrit=false;
            if(tohit-this.attack==20)
            {  
                iscrit=true;
            }

            Attackinformation attackinformation =new Attackinformation(tohit,dmg,target,iscrit);
            return attackinformation;
        }
        else if(action.contains("cancel"))
        {return this.combatloop();
        }
        else
        {System.out.println("not a valid command");
            return this.combatloop();
        }
    }
}
