package daniel.perceptron.main;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Main extends JFrame implements MouseListener {
	
	int pointIndex = 0;
	Point[] points = new Point[2];
	
	public static void main(String[] args) {
		new Main();
	}
	
	Main() {
		// Setup the JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setTitle("Machine Learning Basics");
		setVisible(true);
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
		// Check if the slope of the line is undefined, otherwise set the points.
		if (pointIndex == 1 && pressLocation.x == points[0].x) {
			System.out.println("Undefined Slope!");
		} else {
			// Set either the first or second point to the press location depending on the last one set.
			points[pointIndex] = pressLocation;
			// Flip the bit. (if its 1 set it to 0 and if its 0 set it to 1)
			pointIndex = ~pointIndex;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
