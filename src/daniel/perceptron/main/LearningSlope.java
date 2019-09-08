package daniel.perceptron.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import daniel.perceptron.learning.Perceptron;

public class LearningSlope extends JFrame implements MouseListener {
	
	Canvas canvas = new Canvas();
	
	int pointIndex = 0;
	Point[] points = new Point[2];
	
	Perceptron perceptron = new Perceptron(2);
	
	int correctGuesses = 0, totalGuesses = 0;
	
	public static void main(String[] args) {
		new LearningSlope();
	}
	
	LearningSlope() {
		// Setup the JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Machine Learning Basics");
		setBackground(Color.WHITE);
		setForeground(Color.RED);
		setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
		
		add(canvas);
		
		// Add the mouse listener for mouse inputs
		canvas.addMouseListener(this);
		
		setVisible(true);
		canvas.createBufferStrategy(3);
	}
	
	void render() {
		// Get the current buffer of the canvas
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics g = bufferStrategy.getDrawGraphics();
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(getForeground());
		if (points[1] != null) {
			g.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);
			g.drawString("Slope: " + getSlope(), 16, 16);
			g.drawString("Perceptron Guess: ", getWidth() - 160, 16);
			int guess = perceptron.guess(getYValues());
			g.drawString("Slope " + ((guess == 1) ? ">= 0" : "< 0"), getWidth() - 160, 32);
			boolean correct = (guess == 1 && getSlope() >= 0) || (guess == -1 && getSlope() < 0);
			if (correct)
				correctGuesses++;
			totalGuesses++;
			g.drawString("Guess is " + ((correct) ? "correct" : "incorrect"), getWidth() - 160, 48);
			g.drawString("Percent correct: " + (int) ((float) correctGuesses / totalGuesses * 100) + "%", getWidth() - 160, 64);
		}
		g.setColor(Color.BLUE);
		if (points[0] != null)
			g.drawRect(points[(pointIndex == 1) ? 0 : 1].x - 2, points[(pointIndex == 1) ? 0 : 1].y - 2, 5, 5);
		g.dispose();
		bufferStrategy.show();
	}
	
	float getSlope() {
		return (float) (points[0].y - points[1].y) / (points[1].x - points[0].x);
	}
	
	int[] getYValues() {
		int[] yVals = {points[0].y, points[1].y};
		return yVals;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Get the location of the mouse press when the user releases the mouse
		Point pressLocation = e.getPoint();
		// Check if the slope of the line is undefined, then if it's the same point as the last, otherwise set the points.
		if (pointIndex == 1 && pressLocation.x == points[0].x) {
			System.out.println("Undefined Slope!");
		} else if (pointIndex == 1 && pressLocation.x == points[0].x && pressLocation.y == points[0].y) {
			System.out.println("Same Point!");
		} else {
			// Set either the first or second point to the press location depending on the last one set.
			points[pointIndex] = pressLocation;
			if (points[1] != null)
				perceptron.train(getYValues(), (getSlope() >= 0) ? 1 : -1);
			// Flip the bit. (if its 1 set it to 0 and if its 0 set it to 1)
			pointIndex = (pointIndex == 0) ? 1 : 0;
			render();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
