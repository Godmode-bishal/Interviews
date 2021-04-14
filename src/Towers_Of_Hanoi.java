import java.util.Arrays;

public class Towers_Of_Hanoi {
	public static void main(String[] args) {
		int source[] = { 1, 2, 3 };
		int destination[] = { 0, 0, 0 };
		int auxiliary[] = { 0, 0, 0 };
		hanoi(3, source, destination, auxiliary);
		System.out.println("Destination: "+Arrays.toString(destination));
	}

	public static void hanoi(int n, int[] source, int[] destination, int[] auxiliary) {
		if (n == 1) {
			System.out.println(
					"Moving slab 1 from peg " + Arrays.toString(source) + " to destination");
			destination[n-1]=source[n-1];
			return;
		} else {
			// Move (n-1) slabs from source to auxiliary making destination as
			// auxiliary
			hanoi(n - 1, source, auxiliary, destination);
			// Move nth disk from source to destination
			System.out.println("Moving slab " + n + "from peg " + Arrays.toString(source) + " to destination");
			destination[n-1]=source[n-1];
			// Move (n-1) slabs from auxiliary to destination making source //the
			// auxiliary
			hanoi(n - 1, auxiliary, destination, source);
		}
	}
}
