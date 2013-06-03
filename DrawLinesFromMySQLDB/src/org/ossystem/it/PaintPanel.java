package org.ossystem.it;

import  java.awt.*;
import  javax.swing.*;
import  java.util.*;
import java.util.List;


class  PaintPanel  extends  JPanel  {

	private static final long serialVersionUID = -1774331048649370207L;
	
	Insets  ins;  //  хранит размеры  внутренней  части панели	

	PaintPanel()  {
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,  5));		
}
	
	protected void paintComponent(Graphics  g)  {
		Point pStart = null, pEnd = null;
		List<Point> list = PointDAOImpl.getInstance().getAllPoints();
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