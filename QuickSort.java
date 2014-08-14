public class QuickSort
{
	private static int partition(int[] arr, int left, int right) {
		int i=left, j = right+1, pivot = arr[left];
		while(true) {
			while(i<right && arr[++i] < pivot);
			while(j>left && arr[--j] > pivot);
			if(i>=j) break;
			swap(arr,i,j); 
		}
		swap(arr,left,j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static void quickSort(int[] arr, int left, int right) {
		if(left >= right) return;
		int p = partition(arr, left, right);
		quickSort(arr, left, p-1);
		quickSort(arr, p+1, right);
	}

	public static void sort(int[] a) {
		quickSort(a, 0, a.length-1);
	}

	private static void show(int[] a) {
		for(int i=0;i<a.length; i++) StdOut.print(a[i] + " ");
		StdOut.println("");
	}
	public static void main(String[] args) {
		int[] a = {9,4,3,2,1,8,6,5,7,2};
		sort(a);
		show(a);
	}
}