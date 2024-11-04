
public class DocCnt implements Comparable<DocCnt>
{
    // instance variables - replace the example below with your own
    private Doc doc; 
    private int cnt;

    /**
     * Constructor for objects of class PairFileFreq
     */
    public DocCnt(Doc d)
    {
        this.doc = d;
        cnt = 0;
    }
    public DocCnt (Doc d, int cnt)
    {
        this.doc = d;
        this.cnt = cnt;
    }
    public Doc doc()
    {
        return doc;
    }
    
    public int cnt()
    {
        return cnt;
    }
    public int compareTo(DocCnt that) {
        if (this.cnt == that.cnt) return 0;
        else if (this.cnt < that.cnt) return 1;
        else return -1;
    }
    public String toString() {
        return String.format("%15s %4d", this.doc.title(), cnt);
    }
}
