package com.itweixiang.study.recursion;

import java.util.Arrays;

public class MazeDemo {
    public static void main(String[] args) {
        //模拟迷宫
        int[][] map = new int[8][7];
        //1表示墙
        //把迷宫的边界置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        setWay(map,1,1);
        for (int i = 0; i < map.length; i++) {
            int[] ints = map[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 当map[6][5]时，则说明通路找到
     * 0表示没走过，1表示墙，2表示通路，3表示死路
     * 走路方向的策略，下右上左
     *
     * @param map
     * @param x   y,起点坐标
     * @return 找到则返回true
     */
    public static boolean setWay(int[][] map, int x, int y) {
        if (map[4][1] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {
                //假定走通
                map[x][y] = 2;
                if (setWay(map, x + 1, y)) {
                    return true;
                } else if (setWay(map, x, y + 1)) {
                    return true;
                } else if (setWay(map, x - 1, y)) {
                    return true;
                } else if (setWay(map, x, y - 1)) {
                    return true;
                } else {
                    map[x][y] = 3;
                    return false;
                }
            } else{
                //1,2,3
                return false;
            }
        }
    }
}