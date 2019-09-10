package daniel.perceptron.learning;

public class Perceptron {
	
	float[] weights;
	
	// A modifier to make sure that it doesn't overshoot its goal
	float learningRate = 0.01f;
	
	public Perceptron(int numInputs) {
		// Initialize the weights
		weights = new float[numInputs];
		// Generate random values for all the weights at the beginning
		for (int i = 0; i < weights.length; i++)
			weights[i] = (float) Math.random() * 2 - 1;
	}
	
	public void train(int[] inputs, int slope) {
		// Get a guess
		int guess = guess(inputs);
		// Calculate the error
		int error = slope - guess;
		// Adjust the weights based on the error and how off they were
		for (int i = 0; i < weights.length; i++)
			weights[i] += error * inputs[i] * learningRate;
	}
	
	public int guess(int[] inputs) {
		// init a var for the weighted sum
		float sum = 0;
		// Calculate the weighted sum
		for (int i = 0; i < inputs.length; i++)
			sum += inputs[i] * weights[i];
		// Return the activated sum
		return activate(sum);
	}
	
	// The activation function: turns the weighted sum into an output
	int activate(float sum) {
		// Checks if the sum is greater than or equal to 0 or less than 0
		return (sum >= 0) ? 1 : -1;
	}

}
