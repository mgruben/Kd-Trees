
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;

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
 * Its representation depends on a Binary Search Tree, except the BST's
 * construction depends on the order in which it receives points.
 * 
 * In the worst case, then O(n) performance can be expected for contains()
 * and insert().
 * 
 * In the average case, with sufficiently randomized input, ~O(log n)
 * performance can be expected for contains() and insert().
 * 
 * This implementation is based on algs4.BST, as per the suggestions
 * in this assignment's checklist.
 * 
 * @author Michael <GrubenM@GMail.com>
 */
public class KdTree {
    private Node root;
    private int size;
    
    /**
     * Construct an empty set of points.
     */
    public KdTree() {
        size = 0;
    }
    
    /**
     * Is the set empty?
     * 
     * Note that, while the Nodes in BST store their sizes, that is not done
     * in this implementation.
     * 
     * Accordingly, this simplifies the code from a call to a private helper
     * size method to a check of whether or not the root node is null.
     * 
     * @return {@code true} if this set is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * @return the number of points in the set.
     */
    public int size() {
        return size;
    }
    
    /**
     * Add the point to the set (if it is not already in the set).
     * 
     * At the root (and every second level thereafter), the x-coordinate is
     * used as the key.
     * 
     * This means that if (0.7, 0.2) is the root, then (0.5, 0.9) will be
     * added to the left, since its x-coordinate is smaller than the
     * x-coordinate of the root node.  Similarly, if the next point to be
     * added is (0.8, 0.1), that point will be added to the right of root,
     * since its x-coordinate is larger than the x-coordinate of the root node.
     * 
     * So, visually, we would have:
     *       (0.7, 0.2)
     *      /          \
     * (0.5, 0.9)   (0.8, 0.1)
     * 
     * 
     * At one level below the root (and every second level thereafter), the
     * y-coordinate is used as the key.
     * 
     * This means that if we next add (0.6, 0.8), it will be added to the left
     * of (0.5, 0.9).  Similarly, if we next add (0.4, 0.95), it will be added
     * to the right of (0.5, 0.9).
     * 
     * So, visually, we would have:
     *              (0.7, 0.2)
     *             /          \
     *        (0.5, 0.9)   (0.8, 0.1)
     *       /          \
     * (0.6, 0.8)   (0.4, 0.95)
     * 
     * 
     * @param p the point to add
     * @throws NullPointerException if {@code p} is {@code null}
     */
    public void insert(Point2D p) {
        if (p == null) throw new java.lang.NullPointerException
            ("called insert() with a null Point2D");
        root = insert(root, p, true);
    }
    
    private Node insert(Node n, Point2D p, boolean evenLevel) {
        if (n == null) return new Node(p, evenLevel);
        
        double cmp;
        if (evenLevel) {
            cmp = p.x() - n.p.x();
        }
        else cmp = p.y() - n.p.y();
        
        /**
         * In subsequent levels, the orientation is orthogonal
         * to the current orientation.
         */
        if (cmp < 0) n.lb = insert(n.lb, p, !evenLevel);
        else if (cmp > 0) n.rt = insert(n.rt, p, !evenLevel);
        else n.p = p;
        return n;
    }
    
    /**
     * Does the set contain point p?
     * 
     * In the worst case, this implementation takes time proportional to the
     * logarithm of the number of points in the set.
     * This is because, in the worst case, algs4.SET.contains() takes
     * logarithmic time.
     * That is because, in the worst case, java.util.TreeSet.contains() takes
     * logarithmic time.
     * 
     * @param p the point to look for
     * @return {@code true} if the SET contains point p;
     *         {@code false} otherwise
     * @throws NullPointerException if {@code p} is {@code null}
     */
    public boolean contains(Point2D p) {
        if (p == null) throw new java.lang.NullPointerException
            ("called contains() with a null Point2D");
        return rb.contains(new Node(p));
    }
    
    /**
     * Draw all points to standard draw.
     */
    public void draw() {
        for (Node n: rb) n.p.draw();
    }
    
    /**
     * All points that are inside the rectangle.
     * 
     * In the worst case, this implementation takes time
     * proportional to the number of points in the set.
     * 
     * However, unlike PointSET.range(), in the best case, this implementation
     * takes time proportional to the logarithm of the number of
     * points in the set.
     * 
     * @param rect the RectHV within which to look for points
     * @return an iterator to all of the points within the given RectHV
     * @throws NullPointerException if {@code rect} is {@code null}
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new java.lang.NullPointerException
            ("called range() with a null RectHV");

    }
    
    /**
     * A nearest neighbor in the set to point p; null if the set is empty.
     * 
     * In the worst case, this implementation takes time
     * proportional to the number of points in the set.
     * 
     * However, unlike PointSET.nearest(), in the best case, this
     * implementation takes time proportional to the logarithm of
     * the number of points in the set.
     * 
     * @param p the point from which to search for a neighbor
     * @return the nearest neighbor to the given point p,
     *         {@code null} otherwise.
     * @throws NullPointerException if {@code p} is {@code null}
     */
    public Point2D nearest(Point2D p) {
        if (p == null) throw new java.lang.NullPointerException
            ("called contains() with a null Point2D");
        
        if (rb.isEmpty()) return null;
    }
    
    private static class Node {
        
        // the point
        private Point2D p;
        
        // the axis-aligned rectangle corresponding to this node
        private RectHV rect;
        
        // the left/bottom subtree
        private Node lb;
        
        // the right/top subtree
        private Node rt;
        
        private boolean evenLevel;
        
        private Node(Point2D p, boolean evenLevel) {
            this.p = p;
            this.evenLevel = evenLevel;
        }
        
        
    }
    
    /**
     * Unit testing of the methods (optional).
     * @param args
     */
    public static void main(String[] args) {
        
    }
}
