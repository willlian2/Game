import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class World here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class World
{
    ArrayList<Maptile> planet;
    public World(ArrayList<Maptile> planet)
    {this.planet = planet;
    }
    
    public ArrayList<Maptile> addMaptile(Maptile maptile)
    {   planet.add(maptile);
        return(planet);
    }
}
