package org.opensha2.JavaTest;

import java.awt.Graphics;

import javax.swing.JApplet;

public class TestApplet extends JApplet {
	
	public void paint (Graphics g) {
		
		super.paint(g);
		g.drawString("somethings ...", 20, 30);
	}

}
