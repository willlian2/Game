import java.util.Scanner;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {Fighter fighter = new Fighter();
     Wizard wizard = new Wizard();
     Player player = new Player(fighter,wizard);
     Scanner scanner = new Scanner(System.in);
     Maptile nulltile = new Maptile(7);
     boolean check=true;
     Combat combat = new Combat(fighter);
     System.out.println("Welcome, exit at the inital prompt closes the game, type only in lower case");
     while(check==true)
     {
      
      String action = player.getplayeraction(nulltile);
      player.checkchancetable(action,combat);
        }
    }
    
}
