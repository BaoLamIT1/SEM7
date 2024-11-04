
/**
 * Write a description of class PairFileFreq here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Arrays;
import java.util.Comparator;
import java.io.File;
public class PairFileFreq implements Comparable<PairFileFreq>
{
    // instance variables - replace the example below with your own
    private File file; 
    private int freq;

    /**
     * Constructor for objects of class PairFileFreq
     */
    public PairFileFreq(File file)
    {
        this.file = file;
        freq = 0;
    }
    public PairFileFreq(File file, int freq)
    {
        this.file = file;
        this.freq = freq;
    }
    public File file()
    {
        return file;
    }
    
    public int freq()
    {
        return freq;
    }
    public int compareTo(PairFileFreq that) {
        if (this.freq == that.freq) return 0;
        else if (this.freq < that.freq) return 1;
        else return -1;
    }
    public String toString() {
        return String.format("%15s %4d", this.file.getName(), freq);
    }
}
