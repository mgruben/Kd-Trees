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
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class PointSET {
   public         PointSET()                               // construct an empty set of points 
   public           boolean isEmpty()                      // is the set empty? 
   public               int size()                         // number of points in the set 
   public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
   public           boolean contains(Point2D p)            // does the set contain point p? 
   public              void draw()                         // draw all points to standard draw 
   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle 
   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty 

   public static void main(String[] args)                  // unit testing of the methods (optional) 
}
