package com.example.problemset2a;


import java.util.ArrayList;

public class GetPath {

    // Fill in your answer for this method
    public static Point current_point = null;
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {

        if (r < 0 || c < 0 || grid[r][c] == 1 ) {
//            System.out.println("r:" + r + " c: " + c + " cp: " + current_point);
//            System.out.println(path);
//            System.out.println("Obstacle");
            return false;
        }
        if (r ==0 && c==0 || getPath(r - 1, c, path, grid) || getPath(r,c-1,path,grid)) {
            current_point = new Point(r, c);
            path.add(current_point);
//            System.out.println("r:" + r + " c: " + c + " cp: " + current_point);
//            System.out.println(path);
            return true;
        }

        return false;
    }

}

//You do not need to change any code below ---------
class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
//--------------------------------------------------

/* HINT:
Your solution ought to work with a grid that is not square.
Here is the grid for Test Case 8:

            final int[][] grid = {
                    {0,0,0,1},
                    {0,1,0,0},
                    {0,1,1,1},
                    {0,0,0,1},
                    {1,1,0,0},
                    {1,1,1,0}
            };

*/

/*
For first case:
(3,2) -> (2,2) -> (1,2) -> return false
(2,2) -> (2,1)
(2,1) -> (1,1) -> (0,1) -> (-1,1) -> return false
(0,1) -> (0,0) -> add to list -> return true
(0,1) is true -> add to list -> return true
(1,1) is true -> add to list -> return true
(2,1) is true -> add to list -> return true
(2,2) is true -> add to list -> return true
(3,2) is true -> add to list -> return true
Therefore ans = true, path = [(0,0), (0,1), (1,1), (2,1), (2,2), (3,2)]

For second case:
(3,2) -> (2,2) -> (1,2) -> return false
(2,2) -> (2,1) -> return false
ans = false, path = null.

 */
