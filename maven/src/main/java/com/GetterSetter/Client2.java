package com.GetterSetter;

public class Client2 {

	public static void main(String[] args) {
		Scores obj = new Scores();
		int[] myScores = { 5, 5, 4, 3, 2, 4 };
		obj.setScores(myScores);
		displayScores(obj.getScores());
		int[] copyScores = obj.getScores();
		copyScores[1] = 1;
		displayScores(obj.getScores());
	}

	private static void displayScores(int[] x) {
		for (int i : x) {
			System.out.println(i+" ");
		}
	}
}
