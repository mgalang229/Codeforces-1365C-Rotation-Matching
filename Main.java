import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			int[] b = fs.readArray(n);
			int[] ind = new int[n];
			for (int i = 0; i < n; i++) {
				ind[b[i]-1] = i;
			}
			int[] L = new int[n+1];
			int[] R = new int[n+1];
			Arrays.fill(L, 0);
			Arrays.fill(R, 0);
			for (int i = 0; i < n; i++) {
				int j = ind[a[i]-1];
				int leftDist = 0;
				int rightDist = 0;
				if (i < j) {
					leftDist = j - i;
					rightDist = n - j + i;
//					System.out.print(a[i] + ": " + "L = " + leftDist + " and ");
//					System.out.println("R = " + rightDist);
				} else {
					rightDist = i - j;
					leftDist = j + n - i;
//					System.out.print(a[i] + ": " + "R = " + rightDist + " and ");
//					System.out.println("L = " + leftDist);
				}
				L[leftDist]++;
				R[rightDist]++;
			}
			int max = 0;
			for (int i = 0; i <= n; i++) {
				max = Math.max(max, Math.max(L[i], R[i]));
			}
			out.println(max);
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
