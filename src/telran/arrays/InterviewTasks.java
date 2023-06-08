package telran.arrays;

public class InterviewTasks {
static public boolean isSumTwoN2(short[] array, short sum) {
	//O(n^2)
	boolean res = false;
	int  i = 0;
	while( i< array.length && !res ) {
		short num =(short) (sum - array[i]);
		int j = i + 1;
		while(j < array.length && !res) {
			if (array[j] == num){
				res  = true;
			}
			j++;
		}
		i++;
	}
	return res;
	//O(n^2)
}

static public boolean isSumTwo(short[] array, short sum){
	//array of POSITIVE numbers or zero
	boolean[] helper = new boolean[sum > 0 ? sum + 1 : Short.MAX_VALUE + 1];
	boolean  res = false;
	int index = 0;
	while(index < array.length && !res) {
		short num = (short) (sum - array[index]);
		if(num >= 0) {
			if (helper[num]) {
				res = true;
			} else {
				helper[array[index]] = true;
			}
		}
		index++;
			
	}
	
	return res;
	//lower complexity O(n)
}

//Array of positive numbers
//O[N] complexity
//use helper array of integers
static public void sort(short[] array) {
	int[] helper = new int[Short.MAX_VALUE + 1];
	for (int i = 0; i < array.length; i++){
		helper[array[i]]++;
	}	
	int count = 0;
	for (int i = 0; i < helper.length; i++) {
		for(int j = 0; j < helper[i]; j ++) {
			array[count] = (short)i;
			count++;
		}
	}
}

//returns max positive number having a negative value with same abs value if exists
//else returns -1  
static public short getMaxWithNegativePresentation(short[] array) {
	short[] helper = new short[Short.MAX_VALUE + 1];
	short res = -1;
	for(int i = 0; i < array.length; i++) {
		if  (array[i] > 0 && helper[array[i]] != 1 && helper[array[i]] != 3) {
			helper[array[i]] += 1;
		}else if (array[i] < 0 && helper[-array[i]] != 2 && helper[-array[i]] != 3) {
			helper[-array[i]] += 2;
		}
	}
	boolean isFound = false;
	int i = Short.MAX_VALUE;
	while(!isFound && i > 0) {
		if (helper[i] == 3) {
			isFound = true;
			res = helper[i];
		}
	}
	return i > 0 ? res : -1;
}

}
