package project.lsd_string_sorts;

public class to_test_lsd_string_sorts {

	public static void main(String[] args) {
		String[] a = { "158", "124", "238", "707", "608", "250", "888" };
		//String[] b = { "BEAG", "AWBC", "DRCA", "CGDB", "ADGC", "BCDD", "BEVF" };
		lsd_sorts(a);
		for (String string : a) {
			System.out.println(string);
		}
	}
	
	public static void lsd_sorts(String[] array_sort) {
		int N = array_sort.length;
		int R = 256;
		int W = array_sort[0].length();
		for (int d = W - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) { 
				count[array_sort[i].charAt(d) + 1]++; // count the frequencies
			}
			for (int k = 0; k < R; k++) { 
				count[k + 1] += count[k]; // compute cumulates
			}
			String temp[] = new String[N];
			for (int i = 0; i < N; i++) {
				temp[count[array_sort[i].charAt(d)]++] = array_sort[i]; // remove cords
			}
			for (int i = 0; i < N; i++) {
				array_sort[i] = temp[i]; // copy back
			}
		}
	}
}
