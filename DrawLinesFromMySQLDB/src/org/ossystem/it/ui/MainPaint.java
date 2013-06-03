package org.ossystem.it.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import org.ossystem.it.db.PointDAOImpl;
import org.ossystem.it.model.Point;

public class MainPaint {

	DrawPanel  drawPanel;
	JButton jbtnAdd, jbtnEdit, jbtnDelete;
	JTextField jtf = new JTextField(10);
	Random rand = new Random();
	JTable jTabPoints;
	PointTable pTable = new PointTable(PointDAOImpl.getInstance().getAllPoints());
	
	MainPaint()  {
		
		JFrame  jfrm =  new JFrame("Paint Lines");		
		jfrm.setLayout(null);
		jfrm.setSize(800,  800);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtf.setVisible(false);
		
		jbtnAdd = new JButton("Add point");
		jbtnDelete = new JButton("Delete point");
		
		drawPanel = new DrawPanel();
		drawPanel.setBounds(15, 15, 300, 300);
		jfrm.add(drawPanel);
				
		jTabPoints = new JTable(pTable);
		jTabPoints.setBounds(350, 15, 300, 800);
		
		jbtnAdd.setBounds(15, 350, 120, 30);
		jbtnDelete.setBounds(170, 350, 120, 30);
		
		jtf.setBounds(170, 390, 120, 30);		
		
		jbtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {								
				Point p = new Point();
				p.setName("New Point");
				p.setXX(rand.nextInt(300));
				p.setYY(rand.nextInt(300));
				PointDAOImpl.getInstance().addPoint(p);				
				jTabPoints.setModel(new PointTable(PointDAOImpl.getInstance().getAllPoints()));
				jTabPoints.repaint();
				drawPanel.updateUI();
			}
		});	
				
		jbtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				jtf.setVisible(true);				
				jtf.addActionListener(new ActionListener() {										
					public void actionPerformed(ActionEvent ae) {					
						int id = Integer.parseInt(jtf.getText());
						PointDAOImpl.getInstance().deletePoint(id);						
						drawPanel.updateUI();
						jTabPoints.setModel(new PointTable(PointDAOImpl.getInstance().getAllPoints()));
						jTabPoints.repaint();
						jtf.setVisible(false);
					}
				}) ;				
			}
		});
						
		jfrm.add(jbtnAdd);
		jfrm.add(jbtnDelete);
		jfrm.add(jtf);
		jfrm.add(jTabPoints);		
		jfrm.setVisible(true);		
	}
		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable()  {
			public void run()  {
				new MainPaint();
			}
		});
	}
}


