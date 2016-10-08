
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * This mutable data type represents a set of points in the "Unit Square".
 * 
 * Its representation depends on a Red-Black (balanced) Binary Search Tree,
 * hence O(log n) is expected for Searching, Inserting, and Deleting.
 * 
 * This particular implementation uses algs4.SET, although notably the same
 * implementation could be achieved through java.util.TreeSet.
 * 
 * More specifically, algs4.SET is a wrapper around java.util.TreeSet.
 * 
 * @author Michael <GrubenM@GMail.com>
 */
public class PointSET {
    private SET rb;
    
    /**
     * Construct an empty set of points.
     */
    public PointSET() {
       
    }
    
    /**
     * Is the set empty?
     * @return
     */
    public boolean isEmpty() {
        
    }
    
    /**
     * Number of points in the set.
     * @return
     */
    public int size() {
        
    }
    
    /**
     * Add the point to the set (if it is not already in the set).
     * @param p
     */
    public void insert(Point2D p) {
        
    }
    
    /**
     * Does the set contain point p?
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {
        
    }
    
    /**
     * Draw all points to standard draw.
     */
    public void draw() {
        
    }
    
    /**
     * All points that are inside the rectangle.
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        
    }
    
    /**
     * A nearest neighbor in the set to point p; null if the set is empty.
     */
    public Point2D nearest(Point2D p) {
        
    }
    
    /**
     * Unit testing of the methods (optional).
     * @param args
     */
    public static void main(String[] args) {
        
    }
}
