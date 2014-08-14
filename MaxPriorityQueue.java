public class MaxPriorityQueue
{
	private int[] pq;
	private int N = 0;

	public MaxPriorityQueue(int maxN) {
		pq = new int[maxN+1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(int key) {
		pq[++N] = key;
		swim(pq, N);
	}

	public int delMax() {
		int max = pq[1];
		swap(pq, 1, N--);
		pq[N+1] = 0;
		sink(pq, 1);
		return max;
	}

	private void swim(int[] a, int k) {
		while(k>1 && a[k/2] < a[k]) {
			swap(a, k/2, k);
			k = k/2;
		}
	}

	private void sink(int[] a, int k) {
		while(2*k <= N) {
			int j = 2*k;
			if(j<N && a[j] < a[j+1]) j++;
			if(a[k] > a[j]) break;
			swap(a, k, j);
			k=j;
		}
	}
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void show() {
		for(int i=0; i<=N; i++) StdOut.print(pq[i] + " ");
		StdOut.println("");
	}
	public static void main(String[] args) {
		MaxPriorityQueue mpq = new MaxPriorityQueue(10);
		mpq.insert(8);
		mpq.insert(1);
		mpq.insert(9);
		mpq.insert(2);
		mpq.insert(3);
		mpq.insert(7);
		mpq.insert(6);
		mpq.insert(10);
		mpq.insert(5);
		mpq.insert(4);

		int a = mpq.delMax();
		a = mpq.delMax();
		a = mpq.delMax();
		a = mpq.delMax();
		mpq.show();
	}
}