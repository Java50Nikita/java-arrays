package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import static telran.arrays.InterviewTasks.*;
import java.util.Random;
import java.util.Arrays;

import org.junit.jupiter.api.Test;


class InterviewTasksTest {
	
	private static final int N_ELEMENTS = 100000;
	private static final int N_RUNS = 10000;

	@Test
	void sortTest() {
		short[] src = { 1, 2, 5, 0, 2, 3, 1, 8, 2, 5, 4, 6 };
		short[] exp = { 0, 1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 8 };
		sort(src);
		assertArrayEquals(exp,src);
		
	}
	@Test 
	void sortMuchRepeatedTest() {
		for (int i = 0; i < N_RUNS; i++) {
			short[] src = getRandomShortArray();
			short[] exp = Arrays.copyOf(src, N_ELEMENTS);
			Arrays.sort(exp);
			sort(src);
			assertArrayEquals(exp,src);
			}
	}
	
	@Test 

	void getMaxWithNegativeTest() { 

	short[] array = {1, 1, 1, -1, 20, 100,200, 100 -100, -100, -20, -40, 80}; 

	short[] array1 = {-40, 1, -40, -6, 2, 3, 40}; 

	short[] array2 = {40, 1, 2, 3, 40, -30}; 

	assertEquals(100, getMaxWithNegativePresentation(array)); 

	assertEquals(40, getMaxWithNegativePresentation(array1)); 

	assertEquals(-1, getMaxWithNegativePresentation(array2)); 

	} 
	
	private short[] getRandomShortArray() {
		short [] res = new short[N_ELEMENTS];
		
		Random gen = new Random();
		for(int i = 0; i < N_ELEMENTS; i++) {
			res[i] = (short) gen.nextInt(0, Short.MAX_VALUE + 1);
		}
		return res;
	}

}
