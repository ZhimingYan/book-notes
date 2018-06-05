/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Ali2.java
 * Date: 18-5-11 下午7:47
 * Author: Xiong Raorao
 */

package top.xraorao.interview.tencent;

import java.util.Scanner;

/**
 * 机器人绕过障碍物.
 *
 * @author Xiong Raorao
 * @since 2018-05-11-19:47
 */
public class Ali2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] inputDatas = new String[5];
    for (int i = 0; i < 5; i++) {
      inputDatas[i] = scanner.nextLine();
    }

    // 输出时间
    int result = 0;
    Coordinate start = new Coordinate(inputDatas[0].split(" "));
    Coordinate end = new Coordinate(inputDatas[1].split(" "));

    int mapRow = Integer.parseInt(inputDatas[2].split(" ")[0]);
    int mapCol = Integer.parseInt(inputDatas[2].split(" ")[1]);
    int[][] map = new int[mapRow][mapCol];
    for (int r = 0; r < mapRow; r++) {
      String rowData = inputDatas[3];
      for (int c = 0; c < mapCol; c++) {
        String[] raw = rowData.split(" ");
        map[r][c] = Integer.parseInt(raw[c]);
      }
    }

    result = searchPath(start, end, map);
    System.out.println(result);

  }

  public static int searchPath(Coordinate start, Coordinate end, int[][] map) {
    int result = 0;

    int shortest = Math.abs(start.x - end.x) + Math.abs(start.y - end.y) +
        Math.abs(start.angle - end.angle) / 90;

    // 每遇到一个障碍物，需要增加转向的时长
    int strainNum = 0;
    int strainNum2 = 0;
    // 相对终点
    Coordinate newEnd = new Coordinate(Math.abs(start.x - end.x), Math.abs(start.y - end.y),
        "NORTH");
    // x==>y
    for (int i = 0; i < newEnd.x; i++) {
      if (map[i][newEnd.y] == 1) {
        strainNum++;
      }
    }
    // y==>x
    for (int j = 0; j < newEnd.y; j++) {
      if (map[newEnd.y][j] == 1) {
        strainNum++;
      }
    }

    result = shortest + strainNum;
    return result;
  }


  static class Coordinate {

    private int x;
    private int y;
    private String orient;
    private int angle;

    public Coordinate(String[] ss) {
      this(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), ss[2]);
    }

    public Coordinate(int x, int y, String orient) {
      this.x = x;
      this.y = y;
      this.orient = orient;
      switch (orient) {
        case "NORTH":
          angle = 90;
          break;
        case "SOUTH":
          angle = 270;
          break;
        case "WEST":
          angle = 180;
          break;
        case "EAST":
          angle = 0;
          break;
        default:
          angle = 0;
          break;
      }
    }
  }

}
