import java.util.Random;

/**
 * Write a description of class Maptile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Maptile
{
    int tile;
    
    public Maptile(int tile)
    {this.tile=tile;
     
        
     
    }
    public int gettilenumber()
    {return(this.tile);
    }
    public String readtile()
    {
    if(tile==1)
         {return("There is a door to the left, a door to the right and a door ahead");            
         } 
        if(tile==2)
        {return("There is a door to the right and a door ahead");
        }
        if(tile==3)
        {return("There is a door ahead");
        }
        if(tile==4)
        {return("There is a door to the right");
        }
        if(tile==5)
        {return("There is a door to the left");
        }
        if(tile==6)
        {return("There is a door to the left and right");
        }
        if(tile==0)
        {return("There is a door to the left and ahead");
        }
        if(tile==7)
        {return("Should not be returned tile 7");
        }
        return("should not be returned");
    }
    
}
