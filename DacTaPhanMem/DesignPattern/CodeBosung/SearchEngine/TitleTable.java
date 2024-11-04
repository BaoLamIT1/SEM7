/**
 * Write a description of class TitleTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.NoSuchElementException;
public class TitleTable
{
    private HashMap <String,Doc> titletable;
    public TitleTable() throws NoSuchElementException
    {
        titletable = new HashMap <String,Doc>();
    }
    public void  addDoc (Doc d) throws NoSuchElementException
    {
     String title = d.title();
     titletable.put(title,d);
    }
    public Doc lookup (String t) throws NoSuchElementException
    {
        if (!(titletable.containsKey(t))) return null;
        else return titletable.get(t);
    }
}
