    
    /**
     * Write a description of class WordTable here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    import java.io.*;
    import java.io.File;
    import java.util.NoSuchElementException;
    import java.util.HashMap;
    //import java.util.Vector;
    public class WordTable
    {
        // instance variables - replace the example below with your own
        private HashMap<String,HashMap<Doc,Integer>>  wordtable;
    
        /**
         * Constructor for objects of class WordTable
         */
        public WordTable() throws NoSuchElementException
        {
        }
        public WordTable(File file) throws NoSuchElementException
        {
         wordtable = new HashMap<String,HashMap<Doc,Integer>>(); 
         try {
             read_nonwords (file);
         } catch (IOException exz) { }
        }
        public WordTable(HashMap<String,HashMap<Doc,Integer>>  table, File file) throws NoSuchElementException
        {
         wordtable = table;   
        }
        private void read_nonwords (File ifile)throws IOException
        {
                System.setIn(new FileInputStream(ifile));
                while (!StdIn.isEmpty()) {
                    String word = StdIn.readString();
                    if (!wordtable.containsKey(word)) {
                        wordtable.put(word,null);
                    }
                }
        }   
        public boolean isInteresting (String w)
        {
        if (wordtable.containsKey(w) && (wordtable.get(w)== null)) {
            return false;
        }
        else return true;
        }
        public HashMap<String,HashMap<Doc,Integer>>  wordtable()
        {
        return this.wordtable;
        }
        
        public DocCnt[] lookup (String k){
            if (!isInteresting(k)) return null;
            if (wordtable.containsKey(k) ) {
                HashMap<Doc,Integer> map = wordtable.get(k);
                int length = map.size();
                //StdOut.println("kich thuoc map " + length);
                DocCnt[] doccount = new DocCnt[length];
                int i = 0;
                for (Doc doc : map.keySet()) {
                    int freq = map.get(doc);
                    doccount[i] = new DocCnt(doc,freq); 
                    //StdOut.println(doccount[i]);
                    i +=1;
                }
                return doccount;
            }
            else {
                StdOut.println("con tro null");
                return null;
            }
        }
        public HashMap<String,Integer> addDoc (Doc d)
        {
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            File file = d.file();
            In in = new In(file);
            while (!in.isEmpty()) {
                    String word = in.readString();
                    //boolean interesting = isInteresting (word);
                    //StdOut.println(word +"la interesting" + interesting);
                    if ((isInteresting (word))) {
                        if(wordtable.containsKey(word)){
                            //HashMap<Doc,Integer> ts = wordtable.get(word);
                            if (wordtable.get(word).containsKey(d)){ 
                            wordtable.get(word).put(d,wordtable.get(word).get(d)+1);
                            //StdOut.println(wordtable.get(word).get(d));
                            }    
                            else {
                            wordtable.get(word).put(d,1); 
                            //StdOut.println(wordtable.get(word).get(d));   
                            }    
                            if (map.containsKey(word)) {
                            map.put(word,map.get(word)+1); 
                            //StdOut.println(word, map.get(word));
                            }
                            else map.put(word,1);
                        }
                        else{    
                            HashMap<Doc,Integer> ts = new HashMap<Doc,Integer>();
                            ts.put(d,1);
                            wordtable.put(word,ts);
                            //StdOut.println(wordtable.get(word).get(d));
                            map.put(word,1);
                        //StdOut.println(map.get(word));
                        //StdOut.println(wordtable.get(word));
                        }
                    }
            }
            return map; 
        }   
}
