package com.GetterSetter;

public class Scores {

	private int[] scores;

	public int[] getScores() {
		int[] copy = new int[this.scores.length];
	    System.arraycopy(this.scores, 0, copy, 0, copy.length);
	    return copy;
//		return this.scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	
}
