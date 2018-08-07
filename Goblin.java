import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Goblin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Goblin extends Enemy
{
    int health=10;
    int attack=3;
    int AC=12;
    public Goblin()
    {
        }
    public void sethealth()
    {
        
        System.out.println(health);
    }
    public void takeattack(Attackinformation attackinformation)
    {if(attackinformation.gettohit()>AC&&attackinformation.iscrit()==true)
        {health=health-attackinformation.getdmg()*2;
            System.out.println("The attack hits the goblin! They take "+attackinformation.getdmg()*2);
        }
        else if(attackinformation.gettohit()>AC&&attackinformation.iscrit()==false)
        {health=health-attackinformation.getdmg();
            System.out.println("The attack hits the goblin! They take "+attackinformation.getdmg());
            
        }
        else
        {System.out.println("The attack misses the goblin!");
        }
    }
    public int basicattack()
    {Random random = new Random();
        int hit=random.nextInt(20)+attack+1;
        return hit;
    }
    public int dmg()
    {Random random = new Random();
        int dmg=random.nextInt(6)+1+1;
        return dmg;
    }
    public int gethealth()
    {return health;
    }
    public int getAC()
    {return AC;
    }
    public Attackinformation combatloop()
    {Random targetrng = new Random();
        int targetchoice = targetrng.nextInt(2);
        String target="null";
        if(targetchoice==0)
        {target="fighter";
         System.out.println("The goblin attacks fighter!");
        }
        else if(targetchoice==1)
        {target="wizard";
         System.out.println("The goblin attacks wizard!");
        }
     int tohit=this.basicattack();
     int dmg = this.dmg();
     boolean iscrit=false;
     if(tohit-this.attack==20)
     {iscrit=true;
        }
     Attackinformation attackinformation = new Attackinformation(tohit,dmg,target,iscrit);
     return attackinformation;
    }
}
