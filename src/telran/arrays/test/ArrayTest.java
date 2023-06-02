package telran.arrays.test;

import org.junit.jupiter.api.Test;

import telran.arrays.ArraysInt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ArrayTest {

	@Test
	void initialTest() {

		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		int[] arr2_3 = arr2;

		assertFalse(arr1 == arr2);
		assertTrue(arr2 == arr2_3);
		assertArrayEquals(arr1, arr2);
		arr2_3[0] = 10;
		arr1[0] = 10;
		assertArrayEquals(arr1, arr2);

	}

	@Test
	void copyOfTest() {
		int[] arr1 = { 10, 5, 15 };
		int[] expected1 = { 10, 5, 15 };
		int[] expected2 = { 10, 5 };
		int[] expected3 = { 10, 5, 15, 0, 0 };

		assertArrayEquals(expected1, Arrays.copyOf(arr1, 3));
		assertArrayEquals(expected2, Arrays.copyOf(arr1, 2));
		assertArrayEquals(expected3, Arrays.copyOf(arr1, 5));

	}

	@Test
	void addNumberTest() {
		int[] arr1 = { 10, 5, 15 };
		int number = 20;
		int[] expected1 = { 10, 5, 15, number };

		assertArrayEquals(expected1, ArraysInt.addNumber(arr1, number));
	}

	@Test
	void arraycopyTest() {
		int[] src = { 1, 2, 3, 4, 5, 6, 7 };
		int[] dest = { 10, 20, 30, 40, 50, 60, 70 };
		int[] expected = { 10, 20, 30, 40, 1, 2, 3 };
		System.arraycopy(src, 0, dest, 4, 3);
		assertArrayEquals(expected, dest);

	}

	@Test
	void insertNumberTest() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		int number = 20;
		int index = 3;
		int[] expected1 = { 1, 2, 3, number, 4, 5, 6, 7 };
		assertArrayEquals(expected1, ArraysInt.insertNumber(arr, index, number));

		number = 30;
		index = 0;
		int[] expected2 = { number, 1, 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected2, ArraysInt.insertNumber(arr, index, number));

		number = 40;
		index = 7;
		int[] expected3 = { 1, 2, 3, 4, 5, 6, 7, number };
		assertArrayEquals(expected3, ArraysInt.insertNumber(arr, index, number));
	}

	@Test
	void removeNumberTest() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		int index = 4;
		int[] expected1 = { 1, 2, 3, 4, 6, 7 };
		assertArrayEquals(expected1, ArraysInt.removeNumber(arr, index));

		index = 0;
		int[] expected2 = { 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected2, ArraysInt.removeNumber(arr, index));

		index = 6;
		int[] expected3 = { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(expected3, ArraysInt.removeNumber(arr, index));

	}

	@Test

	void binarySearchTest() {
		int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5, 10, 13, 15 };
		assertEquals(Arrays.binarySearch(arr, 5), 7);
		assertEquals(Arrays.binarySearch(arr, 1), 0);
		assertEquals(Arrays.binarySearch(arr, 15), 10);

		assertTrue(Arrays.binarySearch(arr, 2) >= 1 && Arrays.binarySearch(arr, 2) <= 2);
		assertTrue(Arrays.binarySearch(arr, 4) >= 4 && Arrays.binarySearch(arr, 4) <= 6);

		assertEquals(Arrays.binarySearch(arr, 0), -1);
		assertEquals(Arrays.binarySearch(arr, 6), -9);
		assertEquals(Arrays.binarySearch(arr, 16), -12);

	}

	@Test
	void insertNumberSortedTest() {
		int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5, 10, 13, 15 };

		int number = 5;
		int[] expected1 = { 1, 2, 2, 3, 4, 4, 4, 5, 5, 10, 13, 15 };
		assertArrayEquals(expected1, ArraysInt.insertNumberSorted(arr, number));

		number = 1;
		int[] expected2 = { 1, 1, 2, 2, 3, 4, 4, 4, 5, 10, 13, 15 };
		assertArrayEquals(expected2, ArraysInt.insertNumberSorted(arr, number));

		number = 15;
		int[] expected3 = { 1, 2, 2, 3, 4, 4, 4, 5, 10, 13, 15, 15 };
		assertArrayEquals(expected3, ArraysInt.insertNumberSorted(arr, number));

		number = 0;
		int[] expected4 = { 0, 1, 2, 2, 3, 4, 4, 4, 5, 10, 13, 15 };
		assertArrayEquals(expected4, ArraysInt.insertNumberSorted(arr, number));

		number = 7;
		int[] expected5 = { 1, 2, 2, 3, 4, 4, 4, 5, 7, 10, 13, 15 };
		assertArrayEquals(expected5, ArraysInt.insertNumberSorted(arr, number));

		number = 20;
		int[] expected6 = { 1, 2, 2, 3, 4, 4, 4, 5, 10, 13, 15, 20 };
		assertArrayEquals(expected6, ArraysInt.insertNumberSorted(arr, number));
	}

	@Test
	void maxLongTest() {
		assertEquals(Long.MAX_VALUE, getLongMax());
	}

	private long getLongMax() {
		long res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res - 1;
	}
	
	void maxIntTest() {
		assertEquals(Integer.MAX_VALUE, getIntMax());
	}

	private int getIntMax() {
		int res = 1;
		while (res > 0) {
			res++;
		}
		return res - 1;
	}

}
