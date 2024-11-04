/**
 * Write a description of class FileFrequencyIndex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.io.File;
public class FileFrequencyIndex {
    // Do not instantiate.
    private FileFrequencyIndex() { }  

    public static void main(String[] args) {
        //throws IOException { 
        //System.setIn(new FileInputStream(new File("ex1.txt")));
        // key = word, value = set of files containing that word
        
        ST<String, ST<File,Integer>> st = new ST<String,ST<File,Integer>>();

        // create inverted index of all files
        StdOut.println("Indexing files");
        for (String filename : args) {
            StdOut.println("  " + filename);
            File file = new File(filename);
            In in = new In(file);
            
            while (!in.isEmpty()) {
                String word = in.readString();
                if (st.contains(word)) {
                    ST<File,Integer> st_file = st.get(word); 
                    if (st_file.contains(file)){
                    int freq = st_file.get(file);
                    st_file.put(file,freq+1);
                    }
                    else st_file.put(file,1);
                    
                }
                else {    
                    st.put(word, new ST<File,Integer>());
                    ST<File,Integer> st_file = st.get(word);
                    st_file.put(file,1);
                }
            }
        }


        // read queries from standard input, one per line
        //while (!StdIn.isEmpty()) {
            //String query = "age";
            String query = "was";
            StdOut.println(query);
            if (st.contains(query)) {
                ST<File,Integer> st_file = st.get(query);
                for (File file : st_file.keys()) {
                    StdOut.println("  " + file.getName() + " " + st_file.get(file));
                }
            }
            query = "times";
            StdOut.println(query);
            if (st.contains(query)) {
                ST<File,Integer> st_file = st.get(query);
                for (File file : st_file.keys()) {
                    StdOut.println("  " + file.getName() + " " + st_file.get(file));
                }
            }
        //}

    }
        
}