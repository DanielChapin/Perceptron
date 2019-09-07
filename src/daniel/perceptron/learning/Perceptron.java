package daniel.perceptron.learning;

public class Perceptron {
	
	float[] weights = new float[2];
	
	float learningRate = 0.01f;
	
	public Perceptron() {
		// Generate random values for all the weights at the beginning
		for (int i = 0; i < weights.length; i++)
			weights[i] = (float) Math.random() * 2 - 1;
	}
	
	public void train(int[] inputs, int slope) {
		int guess = guess(inputs);
		int error = slope - guess;
		for (int i = 0; i < weights.length; i++)
			weights[i] += error * inputs[i] * learningRate;
	}
	
	public int guess(int[] inputs) {
		float sum = 0;
		for (int i = 0; i < inputs.length; i++)
			sum += inputs[i] * weights[i];
		return activate(sum);
	}
	
	int activate(float sum) {
		return (sum >= 0) ? 1 : -1;
	}

}
