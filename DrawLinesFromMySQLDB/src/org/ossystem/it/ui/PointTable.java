package org.ossystem.it.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.ossystem.it.model.Point;

public class PointTable extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1226626551011922947L;
	
	ArrayList<Point> points;
	
	public PointTable(ArrayList<Point> points) {
	    super();
	    this.points = points;
	}

	@Override
	public int getRowCount() {		
		return points.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
        case 0:
            return points.get(rowIndex).getId();
        case 1:
            return points.get(rowIndex).getName();
        case 2:
            return points.get(rowIndex).getXX();
        case 3:
            return points.get(rowIndex).getYY();
        default:
            return "";
		}
	}
	
	@Override
	public String getColumnName(int column) {
	    String result = "";
	    switch (column) {
	        case 0:
	            result = "ID";
	            break;
	        case 1:
	            result = "Name";
	            break;
	        case 2:
	            result = "XX";
	            break;
	        case 3:
	            result = "YY";
	            break;
	    }
	    return result;
	}

}
