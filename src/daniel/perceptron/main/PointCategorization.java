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

public class PointCategorization extends JFrame implements MouseListener {
	
	Canvas canvas = new Canvas();
	
	Point[] points = new Point[100];
	
	Perceptron perceptron = new Perceptron(points.length);

	public static void main(String[] args) {
		new PointCategorization();
	}
	
	PointCategorization() {
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
		g.drawLine(0, 0, getWidth(), getHeight());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
