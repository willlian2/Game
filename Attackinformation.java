import java.util.ArrayList;
/**
 * Write a description of class Attackinformation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Attackinformation extends ArrayList
{   int tohit;
    int dmg;
    String target;
    boolean iscrit;
    public Attackinformation(int tohit, int dmg, String target,boolean iscrit)
    {this.tohit=tohit;
     this.dmg=dmg;
     this.target=target;
     this.iscrit=iscrit;
    }
    public int gettohit()
    {return this.tohit;
    }
    public int getdmg()
    {return this.dmg;
    }
    public String target()
    {return this.target;
    }
    public boolean iscrit()
    {return this.iscrit;
    }
}
