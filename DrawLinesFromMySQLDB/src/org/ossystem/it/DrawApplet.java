package org.ossystem.it;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

/*
<applet  code="Lines"  width=300  height=200>
</applet>
*/


public class DrawApplet extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7762880105970874990L;

	public  void  paint(Graphics  g)  {		
		Point pStart = null, pEnd = null;
		List<Point> list = PointDAOImpl.getInstance().getAllPoints();
		Iterator<Point> it = list.iterator();
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
