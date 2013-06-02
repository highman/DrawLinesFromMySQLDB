package org.ossystem.it;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class PaintDemo {
	JLabel  jlab;
	PaintPanel  pp;
	PaintDemo()  {
		JFrame  jfrm =  new JFrame("Paint  Demo");
		jfrm.setSize(500,  500);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pp  =  new  PaintPanel();
		jfrm.add(pp);
		jfrm.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable()  {
			public void run()  {
				new PaintDemo();
			}
		});
	}
}


