package DXC.Logical;

public class LinearSearch {
	// hello
	public static void linearSearch(int[] array, int k) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (k == array[i] && k >= 0 && array.length > 0)
				System.out.print(array[i]);
				count++;
		}
		if (count > 0)
			System.out.println(" element is found");
		else
			System.out.println("element is not found");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 10, 23, 44, 67, 33, 44, 7, 6, 66 };
		linearSearch(input, 23);

	}

}
