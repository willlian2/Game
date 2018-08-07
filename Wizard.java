import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class Wizard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wizard extends Charater
{
    int spellslotlv1 = 2;
    int health=8;
    int attack=2;
    int AC=10;
    public Wizard()
    {
    }
    public Attackinformation castspell()
    
    {
        if(spellslotlv1==0)
        {System.out.println("Wizard has no spell slots left");
        return new Attackinformation(0,0,"out",false);
        }
        else
        {
        System.out.println("What spell will Wizard cast?");
     Scanner getspell = new Scanner(System.in);
     String spell = getspell.nextLine();
     Attackinformation attack = checkspell(spell);
     if(attack.target()=="fail")
     {System.out.println("That is not a spell");
      return castspell();
        }
     else
     {return attack;
        }
    }
    }
    public Attackinformation checkspell(String spell)
    {Spells cast=new Spells();
        if(spell.contains("cure"))
        {
            spellslotlv1=spellslotlv1-1;
            return cast.curewounds();
        }
     else if(spell.contains("magicmissile"))
     {
         spellslotlv1=spellslotlv1-1;
         return cast.magicmissile();
        }
     else
     {
         Attackinformation failedtarget= new Attackinformation(0,0,spell,false);
      return failedtarget;
        }
    }
    public void takeattack(Attackinformation attackinformation)
    {if(attackinformation.gettohit()>AC&&attackinformation.iscrit()==true)
        {health=health-attackinformation.getdmg()*2;
            System.out.println("The attack hits Wizard! They take "+attackinformation.getdmg()*2);
        }
        else if(attackinformation.gettohit()>AC&&attackinformation.iscrit()==false)
        {health=health-attackinformation.getdmg();
            System.out.println("The attack hits Wizard! They take "+attackinformation.getdmg());

        }
        else
        {System.out.println("The attack misses Wizard!");
        }
    }
    public void takehealing(Attackinformation attackinformation)
    {if(health+attackinformation.getdmg()>10)
        {health=12;
         System.out.println("Wizard is healed and now has 10 health");
        }
     else
     {health=health+attackinformation.getdmg();
         System.out.println("Wizard is healed and now has"+health+"health");
        }
    }
    public int basicattack()
    {Random random = new Random();
        int hit=random.nextInt(20)+attack+1;
        return hit;
    }
    public int damage()
    {Random random = new Random();
        int dmg=random.nextInt(4)+1;
        return dmg;
    }
    public int gethealth()
    {return health;
    }

    public int getAC()
    {return AC;
    }
    public Attackinformation combatloop()
    {System.out.println("What will Wizard do?");
        Scanner scanner = new Scanner(System.in);
        String action=scanner.nextLine();
        if(action.contains("attack"))
        {System.out.println("What will wizard attack?");
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
        else if(action.contains("cast"))
        {System.out.println("What will wizard cast?");
         Scanner spellchoice = new Scanner(System.in);
         String spell = scanner.nextLine();
         if(spell.contains("cancel"))
         {return this.combatloop();
            }
         else if(spell.contains("out"))
         {return this.combatloop();
            }
         Attackinformation spellinformation = checkspell(spell);
         if(spellinformation.target.contains("cancel"))
         {return this.combatloop();
            }
         else
         
         {return spellinformation;
            }
        }
        else
        {System.out.println("not a valid command");
            return this.combatloop();
        }
    }
}
