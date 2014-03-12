package com.gledx.rpg.engine;

public class Util {
	public static long getTime(){
		return System.nanoTime() / 1000000;
	}
	private static void flip(int[] array) {
	     int left = 0;
	     int right = array.length - 1;
	     while (left < right) {
	    	 int temp = array[left];
	         array[left] = array[right];
	         array[right] = temp;
	         ++left;
	         --right;
	     }
	 }
	
	public static void flip(int[][] rows) {
	    for (int[] row : rows) {
	        flip(row);
	    } 
	}
}
