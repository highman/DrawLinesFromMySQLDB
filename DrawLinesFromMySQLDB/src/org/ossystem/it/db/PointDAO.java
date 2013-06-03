package org.ossystem.it.db;

import java.util.*;

import org.ossystem.it.model.Point;

public interface PointDAO {
	void addPoint(Point p);
	void editPoint(Point p);
	void deletePoint(int id);
	Point getByID(int id);
	ArrayList<Point> getAllPoints();
}
