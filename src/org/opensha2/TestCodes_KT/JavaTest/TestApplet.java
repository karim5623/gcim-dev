package org.opensha2.JavaTest;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestApplet extends JApplet {
	
//	public void paint (Graphics g) {
//		
//		super.paint(g);
//		g.drawString("somethings ...", 20, 30);
//	}

	public void frame () {
		JFrame f = new JFrame();
		
		JPanel pane = new JPanel();
		
		JButton button = new JButton ("Action Listener");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "action performed");
				
			}
		});
		
		pane.add(button);
		f.add(pane);
		
	}
	
	public static void main (String[] args) {
		
		TestApplet myApp = new TestApplet();	
		
	}
	
}
