package application;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MouseDrag extends Applet implements MouseMotionListener {

	private static final long serialVersionUID = 1L;

	public void init() {
		addMouseMotionListener(this);
		setBackground(Color.red);
	}

	public void mouseDragged(MouseEvent me) {
		Graphics g = getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(me.getX(), me.getY(), 30, 200);
	}

	public void mouseMoved(MouseEvent me) {
	}

}
