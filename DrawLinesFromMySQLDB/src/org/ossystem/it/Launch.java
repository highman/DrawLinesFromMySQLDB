package org.ossystem.it;

import java.util.Iterator;
import java.util.List;

public class Launch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p = new Point();
		Point pTemp;
		p.setName("Start point");
		p.setXX(0);
		p.setYY(0);
		//PointDAOImpl.getInstance().addPoint(p);
		List<Point> list = PointDAOImpl.getInstance().getAllPoints();
		Iterator<Point> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(p);
			pTemp = it.next();
			p = pTemp;
			System.out.println(pTemp);
			
		}				
	}
}
