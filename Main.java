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
    {Player player = new Player();
     Scanner scanner = new Scanner(System.in);
     Maptile nulltile = new Maptile(7);
     boolean check=true;
     System.out.println("Welcome, exit at the inital prompt closes the game, type only in lower case");
     while(check==true)
     {
      
      player.getplayeraction(nulltile);
      
        }
    }
}
