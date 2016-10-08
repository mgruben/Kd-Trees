
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
    private SET<Point2D> rb;
    
    /**
     * Construct an empty set of points.
     */
    public PointSET() {
       
    }
    
    /**
     * Is the set empty?
     * @return {@code true} if this SET is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return rb.isEmpty();
    }
    
    /**
     * @return the number of points in the set.
     */
    public int size() {
        return rb.size();
    }
    
    /**
     * Add the point to the set (if it is not already in the set).
     * 
     * Note that no check for presence is made here before attempting to add,
     * since the documentation of algs4.SET explicitly states:
     * "Adds the key to this set (if it is not already present)"
     * 
     * In the worst case, this implementation takes time proportional to the
     * logarithm of the number of points in the set.
     * 
     * @param p the point to add
     * @throws NullPointerException if {@code p} is {@code null}
     */
    public void insert(Point2D p) {
        if (p == null) throw new java.lang.NullPointerException
            ("called insert() with a null Point2D");
        rb.add(p);
    }
    
    /**
     * Does the set contain point p?
     * 
     * In the worst case, this implementation takes time proportional to the
     * logarithm of the number of points in the set.
     * 
     * @param p the point to look for
     * @return {@code true} if the SET contains point p;
     *         {@code false} otherwise
     * @throws NullPointerException if {@code p} is {@code null}
     */
    public boolean contains(Point2D p) {
        if (p == null) throw new java.lang.NullPointerException
            ("called contains() with a null Point2D");
        return rb.contains(p);
    }
    
    /**
     * Draw all points to standard draw.
     */
    public void draw() {
        for (Point2D p: rb) p.draw();
    }
    
    /**
     * All points that are inside the rectangle.
     * 
     * In the worst case, this implementation takes time proportional to the
     * number of points in the set.
     * 
     * @param rect
     * @return
     * @throws NullPointerException if {@code rect} is {@code null}
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new java.lang.NullPointerException
            ("called range() with a null RectHV");
    }
    
    /**
     * A nearest neighbor in the set to point p; null if the set is empty.
     * 
     * In the worst case, this implementation takes time proportional to the
     * number of points in the set.
     * 
     * @param p the point from which to search for a neighbor
     * @return the nearest neighbor to the point p if the set contains at least
     *         two points, {@code null} otherwise.
     * @throws NullPointerException if {@code p} is {@code null}
     */
    public Point2D nearest(Point2D p) {
        if (p == null) throw new java.lang.NullPointerException
            ("called contains() with a null Point2D");
    }
    
    /**
     * Unit testing of the methods (optional).
     * @param args
     */
    public static void main(String[] args) {
        
    }
}
