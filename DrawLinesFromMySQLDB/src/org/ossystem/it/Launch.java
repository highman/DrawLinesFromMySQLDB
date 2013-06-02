package org.ossystem.it;

import java.util.List;

public class Launch {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Point p = new Point();
		Point pStart = null, pEnd = null;		
		p.setName("Forth point");
		p.setXX(215);
		p.setYY(10);
		PointDAOImpl.getInstance().addPoint(p);
		List<Point> list = PointDAOImpl.getInstance().getAllPoints();
		for(Point temp: list)
			System.out.println(temp);
					
	}
}
