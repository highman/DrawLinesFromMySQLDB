package org.ossystem.it.ui;

import  java.awt.*;
import  javax.swing.*;

import org.ossystem.it.db.PointDAOImpl;
import org.ossystem.it.model.Point;

import  java.util.*;


class DrawPanel extends JPanel {

	private static final long serialVersionUID = -1774331048649370207L;
	
	Insets  ins;  //  хранит размеры  внутренней  части панели	

	DrawPanel()  {
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,  5));		
}
	
	protected void paintComponent(Graphics  g)  {
		Point pStart = null, pEnd = null;
		ArrayList<Point> list = PointDAOImpl.getInstance().getAllPoints();
		Iterator<Point> it = list.iterator();
		super.paintComponent(g) ;		
		ins  =  getInsets();
		while(it.hasNext()) {			
			pEnd = it.next();
			if(pStart == null) {
				pStart = pEnd;
				continue;
			}						
			g.drawLine(pStart.getXX(), pStart.getYY(), pEnd.getXX(), pEnd.getYY());
			pStart = pEnd;						
		}	
	}
}	