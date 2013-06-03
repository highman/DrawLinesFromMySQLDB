package org.ossystem.it.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import org.ossystem.it.db.PointDAOImpl;
import org.ossystem.it.model.Point;

public class PaintLines {

	DrawPanel  pp;
	JButton jbtnAdd, jbtnEdit, jbtnDelete;
	JTextField jtf = new JTextField(10);
	Random rand = new Random();
	JTable jTabPoints;
	PointTable pTable = new PointTable(PointDAOImpl.getInstance().getAllPoints());
	
	PaintLines()  {
		
		JFrame  jfrm =  new JFrame("Paint Lines");
		jtf.setVisible(false);
		jfrm.setLayout(null);
		jfrm.setSize(800,  800);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtnAdd = new JButton("Add point");
		jbtnDelete = new JButton("Delete point");
		pp = new DrawPanel();
		pp.setBounds(15, 15, 300, 300);
		jfrm.add(pp);
		
		jTabPoints = new JTable(pTable);
		jTabPoints.setBounds(350, 15, 300, 300);
		
		jbtnAdd.setBounds(15, 350, 120, 30);
		jbtnDelete.setBounds(170, 350, 120, 30);
		jtf.setBounds(15, 450, 100, 30);
		
		
		jbtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {								
				Point p = new Point();
				p.setName("New Point");
				p.setXX(rand.nextInt(300));
				p.setYY(rand.nextInt(300));
				PointDAOImpl.getInstance().addPoint(p);
				//jTabPoints.updateUI();
				jTabPoints.setModel(new PointTable(PointDAOImpl.getInstance().getAllPoints()));
				jTabPoints.repaint();
				pp.updateUI();
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
						pp.updateUI();
						jtf.setVisible(false);
					}
				}) ;
				jTabPoints.updateUI();
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
				new PaintLines();
			}
		});
	}
}


