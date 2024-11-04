/**
 * Write a description of class FileFrequencyIndex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.io.File;
import java.util.HashMap;
import java.util.Arrays;
//import java.util.NoSuchElementException;
public class FileFreqIndex_Hash {
    // Do not instantiate.
    private FileFreqIndex_Hash() { }  

    public static void main(String[] args) {
        //throws IOException { 
        //System.setIn(new FileInputStream(new File("ex1.txt")));
        // key = word, value = set of files containing that word
        
        HashMap<String, HashMap<File,Integer>> st = new HashMap<String,HashMap<File,Integer>>();

        // create inverted index of all files
        StdOut.println("Indexing files");
        for (String filename : args) {
            StdOut.println("  " + filename);
            File file = new File(filename);
            In in = new In(file);
            
            while (!in.isEmpty()) {
                String word = in.readString();
                if (st.containsKey(word)) {
                    HashMap<File,Integer> st_file = st.get(word); 
                    if (st_file.containsKey(file)){
                    int freq = st_file.get(file);
                    st_file.put(file,freq+1);
                    }
                    else st_file.put(file,1);
                    
                }
                else {    
                    st.put(word, new HashMap<File,Integer>());
                    HashMap<File,Integer> st_file = st.get(word);
                    st_file.put(file,1);
                }
            }
        }


        // read queries from standard input, one per line
        //while (!StdIn.isEmpty()) {
            //String query = "age";
            String query = "was";
            StdOut.println(query);
            if (st.containsKey(query)) {
                HashMap<File,Integer> st_file = st.get(query);
                int length = st_file.size();
                PairFileFreq []  pairs = new  PairFileFreq [length]; 
                int i = 0;
                for (File file : st_file.keySet()) {
                    int freq = st_file.get(file);
                    pairs[i] =  new PairFileFreq (file, freq); 
                    i +=1; 
                    StdOut.println(" " + file.getName() + " " + st_file.get(file));
                }
                StdOut.println("Sap xep");
                Arrays.sort(pairs);
                for (int j = 0; j < pairs.length; j++)
                StdOut.println(pairs[j]);
            }

    }
        
}