
/**
 * Write a description of class Combat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Combat
{
    Fighter fighter = new Fighter();
    Wizard wizard = new Wizard();
    public Combat(Fighter fighter)
    {this.fighter=fighter;
     this.wizard=wizard;
    }
    public void singlegoblin()
    {Goblin goblin = new Goblin();
        System.out.println(fighter.gethealth());
        System.out.println("A goblin attacks! Valid targets are goblin");
     while(true)
     {  if(fighter.gethealth()>0)
         {
         Attackinformation fighterattack = this.fighter.combatloop();
         if(fighterattack.target().contains("goblin")==true)
         {goblin.takeattack(fighterattack);
            }
         else
         {System.out.println(fighterattack.target()+"is not a valid target");
          continue;
            }
        }
        else
        {System.out.println("The fighter is dead!");
        }
           if(goblin.gethealth()<=0)
      {break;
        }
        if(wizard.gethealth()>0)
            {
            while(true)
            {Attackinformation wizardattack = this.wizard.combatloop();
         if(wizardattack.target().contains("goblin")==true)
         {goblin.takeattack(wizardattack);
             break;
            }
         else if(wizardattack.target().contains("wizard"))
         {wizard.takehealing(wizardattack);
             break;
            }
         else if(wizardattack.target().contains("fighter"))
         {fighter.takehealing(wizardattack);
             break;
            }
            else
         {System.out.println(wizardattack.target()+"is not a valid target");
          continue;
            }
            }
        }
        else
        {System.out.println("The wizard is dead!");
        }
      if(goblin.gethealth()<=0)
      {break;
        }
            Attackinformation goblinattack = goblin.combatloop();
      if(goblinattack.target().contains("fighter"))
      {this.fighter.takeattack(goblinattack);
        }
      if(goblinattack.target().contains("wizard"))
      {this.wizard.takeattack(goblinattack);
        }
      if(fighter.gethealth()<=0&&wizard.gethealth()<=0)
      {break;
        }
      
        }
     if(goblin.gethealth()<1)
     {System.out.println("You killed the goblin!");
        }
     else
     {System.out.println("Your party died!");
        }
    }
}
