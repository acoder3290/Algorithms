public class UF
{
    private int[] id;
    private int count;

    public UF(int N)
    {
        count = N;
        id = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    /** Quick Find way **/
    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId) return;

        for(int i=0; i<id.length; i++)
            if(id[i] == pId) id[i] = qId;
        count--;
    }

    /**Quick Union Method **/

    public int quFind(int p)
    {
        while(p != id[p]) p = id[p];
        return p;
    }

    public void qUnion(int p, int q)
    {
        int pRoot = quFind(p);
        int qRoot = quFind(q);

        if(pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;

            //uf.union(p,q);
            uf.qUnion(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " componenets");
    }
}
