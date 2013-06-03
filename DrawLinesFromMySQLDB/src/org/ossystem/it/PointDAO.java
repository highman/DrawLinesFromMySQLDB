package org.ossystem.it;

import java.util.*;

public interface PointDAO {
	void addPoint(Point p);
	void editPoint(Point p);
	void deletePoint(int id);
	Point getByID(int id);
	ArrayList<Point> getAllPoints();
}
