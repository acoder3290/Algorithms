public class MergeSort
{
    private static int[] aux;
    public static void sort(int[] a) {
        aux = new int[a.length];
       // mergeSort(a,0,a.length-1);
       int N = a.length;
       for(int sz=1;sz<N; sz += sz)
           for(int lo=0;lo<N-sz; lo +=sz+sz)
               merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));

    }
    public static void merge(int[] a, int lo, int mid, int hi) {
        int i=lo,j=mid+1;
        for(int k = lo; k<=hi;k++) aux[k] = a[k];
        for(int k=lo; k<=hi; k++) {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(aux[j]< aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void mergeE(int[] a, int lo, int mid, int hi) {
        int i=lo,j=mid+1;
        for(int k=lo; k<=hi;k++) aux[k] = a[k];
        int t = lo;
        while(i<=mid && j<=hi) {
            if(aux[i] < aux[j]) a[t++] = aux[i++];
            else a[t++] = aux[j++];
        }

        while(i<=mid) a[t++] = aux[i++];
        while(j<=hi) a[t++] = aux[j++];
    }

    public static void mergeSort(int[] a, int lo, int hi) {
       if(hi <= lo) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(a,lo,mid);
        mergeSort(a,mid+1,hi);
        mergeE(a,lo,mid,hi);
    }

    public static void show(int[] a) {
        for(int i=0;i<a.length;i++) {
            StdOut.print(a[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] a = {9,5,4,8,6,7,3,2};
        sort(a);
        show(a);
    }
}
