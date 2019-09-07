package daniel.perceptron.learning;

import java.awt.Point;

public class Perceptron {
	
	float[] weights = new float[2];
	
	float learningRate = 0.01f;
	
	public Perceptron() {
		// Generate random values for all the weights at the beginning
		for (int i = 0; i < weights.length; i++)
			weights[i] = (float) Math.random() * 2 - 1;
	}
	
	public void train(Point[] points, int slope) {
		int[] coordinates = {points[0].y, points[1].y};
		int guess = guess(coordinates);
		int error = slope - guess;
		for (int i = 0; i < weights.length; i++)
			weights[i] += error * coordinates[i] * learningRate;
	}
	
	public int guess(Point[] points) {
		int[] coordinates = {points[0].y, points[1].y};
		return guess(coordinates);
	}
	
	int guess(int[] coordinates) {
		float sum = 0;
		for (int i = 0; i < coordinates.length; i++)
			sum += coordinates[i] * weights[i];
		return activate(sum);
	}
	
	int activate(float sum) {
		return (sum >= 0) ? 1 : -1;
	}

}
