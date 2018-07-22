/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: UF.java
 * Date: 18-7-22 下午3:32
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.uf;

/**
 * 并查集抽象类.
 *
 * 用于解决动态连通性问题，能动态连接两个点，并且判断两个点是否连通
 *
 * 方法	描述
 * UF(int N)	构造一个大小为 N 的并查集
 * void union(int p, int q)	连接 p 和 q 节点
 * int find(int p)	查找 p 所在的连通分量
 * boolean connected(int p, int q)	判断 p 和 q 节点是否连通
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:16
 */
public abstract class UF {

  protected int[] id;

  public UF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public abstract int find(int p);

  public abstract void union(int p, int q);
}
