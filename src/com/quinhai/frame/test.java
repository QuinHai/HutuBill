package com.quinhai.frame;

public class test {
	public static void main(String[] args) {
		int[] array_A = {1,7,9,11,13,15,17,19};
		int[] array_B = {2,4,6,8,10};
		int[] array_C = new int[20];
		int count = 0;
		
		for(int i:array_A) {
			array_C[count++] = i;
		}
		
		for(int i:array_B) {
			array_C[count++] = i;
		}
		
		for(int i = 0;i < count;i++) {
			System.out.println(array_C[i]);
		}
	}
}
