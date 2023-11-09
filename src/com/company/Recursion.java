package com.company;

public class Recursion {

    private static int[][] map = new int[][]{
            {0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0},
            {0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0},
            {0,0,0,1,1,1,0}
    };

    public static void lesson() {
        move(0,0);
    }

    public static boolean move(int i, int j) {
        boolean res = false;
        if(i != map.length-1) {
            res = move(i +1,j);
        }
        if(map[i][j] != 0) {
            return false;
        }
        if(res) {
            System.out.println(i + " "+ j);
            return res;
        }
        if(j != map[0].length-1) {
            res = move(i, j+1);
        }
        if((j == map[0].length - 1) && (i == map.length-1)){
            System.out.println(i + " "+ j);
            return true;
        }
        if(res) {
            System.out.println(i + " "+ j);
        }
        return res;
    }
}
