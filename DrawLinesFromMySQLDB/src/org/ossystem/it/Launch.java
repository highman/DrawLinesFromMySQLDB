package org.ossystem.it;

import java.util.List;

public class Launch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p = new Point();
		p.setName("Point 1");
		p.setXX(2);
		p.setYY(4);
		PointDAOImpl.getInstance().addPoint(p);
		//List<Point> list = PointDAOImpl.getInstance().getAllPoints();
		//for(Point p3 : list)
			//System.out.println(p3);
			

	}

}
