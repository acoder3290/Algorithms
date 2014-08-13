import java.util.Arrays;

public class BinarySearch
{
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;

		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid]) hi = mid -1;
			else if(key > a[mid]) lo = mid + 1;
			else return a[mid];
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);

		
		Arrays.sort(whitelist);
		
		while (!StdIn.isEmpty())
			{ // Read key, print if not in whitelist.
				int key = StdIn.readInt();
				StdOut.println(key);
				if (rank(key, whitelist) < 0)
					StdOut.println(key);
			}
	}
}