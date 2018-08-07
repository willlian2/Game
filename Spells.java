import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class Spells here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spells
{
    public Spells()
    {
    }
    public Attackinformation curewounds()
    {Random healrandom = new Random();
     int heal=healrandom.nextInt(8)+1;
     Scanner targetget = new Scanner(System.in);
     System.out.println("Who will you cure?");
     String target = targetget.nextLine();
     
     Attackinformation healattack = new Attackinformation(0,heal,target,false);
     return healattack;
    }
    public Attackinformation magicmissile()
    {Random dmgrandom = new Random();
        int dmg = dmgrandom.nextInt(4)+dmgrandom.nextInt(4)+dmgrandom.nextInt(4)+3;
     Scanner targetget = new Scanner(System.in);
     System.out.println("Who will you target?");
     String target = targetget.nextLine();
     Attackinformation attack = new Attackinformation(100,dmg,target,false);
     return attack;
    }
}
