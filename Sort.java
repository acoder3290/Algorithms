public class Sort
{
    private Sort() {}

    public static void selectionSort(Comparable[] a) {
        int N = a.length;

        for(int i=0; i < N; i++) {
            int min = i;
            for(int j=i+1; j<N; j++) {
                if(less(a[j],a[min])) min = j;
            }
            exch(a,i,min);
        }
    }

    public static void insertionSort(Comparable[] a) {
        int N = a.length;
        for(int i=1;i<N;i++) {
            for(int j=i; j>0 ; j--) {
                if(less(a[j-1],a[j])) break;
                exch(a,j,j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return(v.compareTo(w) < 0);
    }

    private static void exch(Object[] a, int i, int j)
    {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            StdOut.print(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
       // SelectionSort.sort(a);
       Sort.insertionSort(a);
        show(a);
    }
}
