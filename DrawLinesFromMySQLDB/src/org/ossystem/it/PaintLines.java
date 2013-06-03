package org.ossystem.it;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class PaintLines {

	PaintPanel  pp;
	JButton jbtnAdd, jbtnEdit, jbtnDelete;
	Random rand = new Random();
	JTable jTabPoints;
	PointTable pTable = new PointTable(PointDAOImpl.getInstance().getAllPoints());
	
	PaintLines()  {
		
		JFrame  jfrm =  new JFrame("Paint Lines");
		jfrm.setLayout(null);
		jfrm.setSize(800,  800);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtnAdd = new JButton("Add point");
		jbtnDelete = new JButton("Delete point");
		pp  =  new  PaintPanel();
		pp.setBounds(15, 15, 300, 300);
		jfrm.add(pp);
		
		
		jbtnAdd.setBounds(15, 350, 120, 30);
		jbtnDelete.setBounds(170, 350, 120, 30);
		
		
		jbtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {								
				Point p = new Point();
				p.setName("New Point");
				p.setXX(rand.nextInt(300));
				p.setYY(rand.nextInt(300));
				PointDAOImpl.getInstance().addPoint(p);
				pTable.fireTableDataChanged();								
			}
		});	
		
		
		jbtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {

			}
		});
		
		
		jTabPoints = new JTable(pTable);
		jTabPoints.setBounds(350, 15, 300, 300);
		jfrm.add(jbtnAdd);
		jfrm.add(jbtnDelete);
		
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


