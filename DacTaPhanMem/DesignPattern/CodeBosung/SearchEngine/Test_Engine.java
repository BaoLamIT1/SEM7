
/**
 * Write a description of class Test_Engine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.io.File;
import java.util.HashMap;
public class Test_Engine
{
    public Test_Engine()
    {
       
    }

    public static void main(String[] args) throws IOException {
        File ifile = new File("nonwords.txt"); 
        WordTable wt  = new WordTable(ifile);
        TitleTable ttable = new TitleTable();        

        for (String filename : args) {
            File file = new File(filename);
            Doc doc = new Doc(file);
            ttable.addDoc(doc);
            HashMap<String,Integer> add_table = wt.addDoc(doc);
        } 
        Query query = new Query(wt);
        Engine engine = new Engine(query);
        engine.settitletable(ttable);
        query = engine.queryFirst("was");
        String[] khoa = engine.query().keys();
        for(int i=0; i < khoa.length && !(khoa[i]==null); i++) StdOut.println(khoa[i]);
        if (!(query.results() == null))
        for (int j = 0; j < query.size(); j++)
                StdOut.println(query.fetch(j).title());
        engine.queryMore ("age");
        khoa = engine.query().keys();
        for(int i=0; i < khoa.length && !(khoa[i]==null); i++) StdOut.println(khoa[i]);
        for (int j = 0; j < query.size(); j++)
                StdOut.println(query.fetch(j).title());
        engine.queryMore ("times");
        khoa = engine.query().keys();
        for(int i=0; i < khoa.length && !(khoa[i]==null); i++) StdOut.println(khoa[i]);
        for (int j = 0; j < query.size(); j++)
                StdOut.println(query.fetch(j).title());
    }
   
}
