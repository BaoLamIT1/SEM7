
/**
 * Write a description of class Doc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
public class Doc
{
    // instance variables - replace the example below with your own
    private File file;

    public Doc(File file)
    {
     this.file = file;   
    }

    public String title()
    {
        return file.getName();
    }
    public String body()
    {
        return " ";
    }
    public File file()
    {
        return file;
    }
}
